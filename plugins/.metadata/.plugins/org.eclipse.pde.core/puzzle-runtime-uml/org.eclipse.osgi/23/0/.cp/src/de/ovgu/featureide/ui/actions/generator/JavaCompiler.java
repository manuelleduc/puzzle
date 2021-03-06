/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2015  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 * 
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */
package de.ovgu.featureide.ui.actions.generator;

import static de.ovgu.featureide.fm.core.localization.StringTable.CANNOT_FIND_SYMBOL;
import static de.ovgu.featureide.fm.core.localization.StringTable.COMPILER;
import static de.ovgu.featureide.fm.core.localization.StringTable.SYMBOL;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.compiler.batch.BatchCompiler;

import de.ovgu.featureide.ui.UIPlugin;

/**
 * This {@link Job} compiles all configurations of the corresponding {@link Generator}
 * 
 * @author Jens Meinicke
 */
public class JavaCompiler implements IConfigurationBuilderBasics {

	private final Generator generator;

	/**
	 * The parent folder of the generated variants
	 */
	final IFolder tmp;
	

	/**
	 * 
	 * @param nr The number of the compiler
	 * @param generator The generator holding this compiler
	 */
	public JavaCompiler(int nr, Generator generator) {
		this.generator = generator;

		tmp = generator.builder.tmp.getFolder(COMPILER + nr);
		if (!tmp.exists()) {
			try {
				tmp.create(true, true, null);
			} catch (CoreException e) {
				UIPlugin.getDefault().logError(e);
			}
		}
		
	}

	/**
	 * Compiles the given configuration.
	 * 
	 * @param configuration The configuration to build
	 * @throws CoreException 
	 */
	protected void compile(BuilderConfiguration configuration) throws CoreException {
		try {
			generator.builder.folder.getFolder(configuration.getName()).refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			UIPlugin.getDefault().logError(e);
		}
		for (IResource file : tmp.members()) {
			file.delete(true, null);
		}
		compile(configuration.getName());
	}

	/**
	 * Compiles the built configuration to create error markers.
	 * The binary files will be placed into an temporary folder.
	 * 
	 * @param confName
	 */
	private void compile(String confName) {
		LinkedList<IFile> files = getJavaFiles(generator.builder.folder.getFolder(confName));
		final LinkedList<String> options = new LinkedList<String>();
		for (IFile file : files) {
			options.add(setupPath(file));
		}
		options.add("-g");
		options.add("-Xlint");
		options.add("-source");
		options.add("1.7");
		options.add("-d");
		options.add(setupPath(tmp.getRawLocation().toOSString()));
		options.add("-classpath");
		options.add(generator.builder.classpath);

		String output = process(options);
		LinkedList<IFile> errorFiles = parseJavacOutput(output, files, confName);
		for (IFile file : errorFiles) {
			generator.builder.featureProject.getComposer().postCompile(null, file);
		}
	}

	/**
	 * Adds quotation marks to the path name if it contains white spaces.
	 */
	private String setupPath(IFile file) {
		return setupPath(file.getRawLocation().toOSString());
	}
	
	/**
	 * Adds quotation marks to the path name if it contains white spaces.
	 */
	private String setupPath(String location) {
		String[] split = location.split("[\\\\]");
		StringBuilder path = new StringBuilder();
		for (String loc : split) {
			path.append("\\");
			if (loc.contains(" ")) {
				path.append("\"");
				path.append(loc);
				path.append("\"");
			} else {
				path.append(loc);
			}
		}
		return path.substring(1);
	}

	private String process(AbstractList<String> command) {
		final StringBuilder sb = new StringBuilder();
		for (String string : command) {
			sb.append(string);
			sb.append(' ');
		}

		String output = null;
		try (StringWriter writer = new StringWriter()) {
			BatchCompiler.compile(sb.toString(), new PrintWriter(System.out), new PrintWriter(writer), null);
			output = writer.toString();
		} catch (IOException e) {
			UIPlugin.getDefault().logError(e);
		}
		return output;
	}

	/**
	 * Generates the problem markers from the given compiler output.
	 * 
	 * @param output The output from the compiler
	 * @param files The compiled files
	 * @param configurationName Name of the actual configuration
	 * @return
	 */
	public LinkedList<IFile> parseJavacOutput(String output, LinkedList<IFile> files, String configurationName) {
		LinkedList<IFile> errorFiles = new LinkedList<IFile>();
		if (output.isEmpty()) {
			return errorFiles;
		}
		TreeMap<String, IFile> sourcePaths = new TreeMap<String, IFile>();
		for (IFile file : files)
			sourcePaths.put(file.getRawLocation().toOSString(), file);

		try (Scanner scanner = new Scanner(output)) {
			String currentLine;
			while (scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				// \S*\s(\w+)\sin\s(\w:[\w,\\,.,\s]*.java)\s[(]at line (\d+)[)]
				Pattern pattern = Pattern.compile("\\S*\\s(\\w+)\\sin\\s(\\S:[\\s,\\S]*.java)\\s[(]at line (\\d+)[)]");
				Matcher matcher = pattern.matcher(currentLine);
				if (!matcher.find()) {
					continue;
				}
				try {
					boolean contains = sourcePaths.containsKey(matcher.group(2));
					if (!contains) {
						continue;
					}
				} catch (Exception e) {
					UIPlugin.getDefault().logError(e);
					continue;
				}
				final boolean warning = "WARNING".equals(matcher.group(1));
				IFile currentFile = sourcePaths.get(matcher.group(2));
				int line = Integer.parseInt(matcher.group(3));
				// get error message in from the next lines
				while (scanner.hasNextLine()) {
					currentLine = scanner.nextLine();
					Pattern messagePattern = Pattern.compile("\\w+[\\w\\W]*");
					Matcher m = messagePattern.matcher(currentLine);
					boolean found = m.matches();
					if (found) {
						break;
					}
				}

				String errorMessage = currentLine;
				//			if (CANNOT_FIND_SYMBOL.equals(errorMessage)) {
				//				errorMessage = parseCannotFindSymbolMessage(scanner);
				//			}
				if (errorMessage.contains(ERROR_IGNOR_RAW_TYPE) || errorMessage.contains(ERROR_IGNOR_CAST) || errorMessage.contains(ERROR_IGNOR_SERIIZABLE)
						|| errorMessage.contains(ERROR_IGNOR_UNUSED_IMPORT) || errorMessage.contains(ERROR_IGNOR_DEPRECATION)) {
					continue;
				}
				if (!errorFiles.contains(currentFile)) {
					errorFiles.add(currentFile);
				}
				IMarker newMarker;
				newMarker = currentFile.createMarker(PROBLEM_MARKER);
				if (newMarker.exists()) {
					newMarker.setAttribute(IMarker.LINE_NUMBER, line);
					newMarker.setAttribute(IMarker.MESSAGE, configurationName + " " + errorMessage);
					newMarker.setAttribute(IMarker.SEVERITY, warning ? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_ERROR);
				}
			}
		} catch (CoreException e) {
			UIPlugin.getDefault().logError(e);
		}

		return errorFiles;
	}

	@SuppressWarnings("unused")
	private String parseCannotFindSymbolMessage(Scanner scanner) {
		while (scanner.hasNextLine()) {
			String currentLine = scanner.nextLine();
			if (currentLine.startsWith(SYMBOL)) {
				String[] tokens = currentLine.split(": ");
				if (tokens.length == 2)
					return CANNOT_FIND_SYMBOL + ": " + tokens[1];
				break;
			}
		}
		return CANNOT_FIND_SYMBOL;
	}

	/**
	 * Looks for all java files at the given folder.
	 * 
	 * @param folder The folder containing the java files
	 * @return A list with all java files at the folder
	 */
	private LinkedList<IFile> getJavaFiles(IFolder folder) {
		LinkedList<IFile> files = new LinkedList<IFile>();
		try {
			for (IResource res : folder.members()) {
				if (res instanceof IFolder) {
					files.addAll(getJavaFiles((IFolder) res));
				} else if ("java".equals(res.getFileExtension())) {
					files.add((IFile) res);
				}
			}
		} catch (CoreException e) {
			UIPlugin.getDefault().logError(e);
		}
		return files;
	}

}
