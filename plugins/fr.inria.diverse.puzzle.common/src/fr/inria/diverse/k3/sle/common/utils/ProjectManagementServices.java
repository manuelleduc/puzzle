package fr.inria.diverse.k3.sle.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author David Mendez Acuna
 */
public class ProjectManagementServices {

	/**
	 * Creates an eclipse project in the workspace
	 * 
	 * @param projectName
	 * @throws CoreException
	 */
	public static IProject createEclipseProject(String projectName)
			throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(projectName);
		project.create(null);
		project.open(null);

		IProjectDescription description = project.getDescription();
		description.setNatureIds(new String[] { JavaCore.NATURE_ID });
		project.setDescription(description, null);

		return project;
	}

	/**
	 * Creates a folder with the name in the parameter on the target project.
	 * 
	 * @param targetProject
	 * @param folderName
	 * @return
	 */
	public static String createFolderByName(IProject targetProject,
			String folderName) {
		String path = targetProject.getLocation().toString() + "/" + folderName;
		File dir = new File(path);
		dir.mkdir();

		return path;
	}

	/**
	 * 
	 * @param project
	 * @throws CoreException
	 */
	public static void refreshProject(IProject project) throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, null);
	}

	/**
	 * Copy the src folder in the dest one
	 * Taken from: http://www.mkyong.com/java/how-to-copy-directory-in-java/
	 * @param src
	 * @param dest
	 * @throws IOException
	 */
	public static void copyFolder(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdir();
			}
			String files[] = src.list();
			for (String file : files) {
				File srcFile = new File(src, file);
				File destFile = new File(dest, file);
				copyFolder(srcFile, destFile);
			}
		} else {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
			in.close();
			out.close();
		}
	}
}