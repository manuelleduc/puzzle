package fr.inria.diverse.puzzle.metrics.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import fr.inria.diverse.k3.sle.common.utils.ProjectManagementServices;
import fr.inria.diverse.k3.sle.common.vos.SynthesisProperties;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.HCCalculator;
import fr.inria.diverse.puzzle.metrics.auxiliarMetrics.PairwiseCohesionMatrix;

/**
 * Action responsible to analyze the domains hierarchy of a given DSL. 
 * 
 * @author David Mendez-Acuna
 */
public class PerformHierarchicalDomainAnalysisActionImpl {

	// -----------------------------------------------
	// Attributes/Constants
	// -----------------------------------------------
	
	private static final String REPORT_PATH_HIERARCHICAL_DOMAIN_ANALYSIS = "Report-HierarchicalDomainAnalysis.html";;
	private static PerformHierarchicalDomainAnalysisActionImpl instance;
	
	// -----------------------------------------------
	// Constructor and singleton
	// -----------------------------------------------
	
	private PerformHierarchicalDomainAnalysisActionImpl(){}
	
	public static PerformHierarchicalDomainAnalysisActionImpl getInstance(){
		if(instance == null)
			instance = new PerformHierarchicalDomainAnalysisActionImpl();
		return instance;
	}
	
	// -----------------------------------------------
	// Methods
	// -----------------------------------------------
	
	/**
	 * Performs the hierarchical domain analysis in the given domain model and generates the corresponding report in HTML. 
	 * @param selectedResource
	 * @return
	 * @throws IOException
	 * @throws CoreException
	 * @throws URISyntaxException
	 */
	public String performDomainAnalysis(SynthesisProperties synthesisProperties, EPackage metamodel, IProject project) throws Exception {
		System.out.println("Performs the domain analysis");
		ProjectManagementServices.createFolderByName(project, "reports");
		ProjectManagementServices.createFolderByName(project, "reports/libs");
		
		List<EClass> metaclasses = new ArrayList<EClass>();
		this.filterEClasses(metamodel, metaclasses);
		double[][] matrix = PairwiseCohesionMatrix.computePairwiseCohesionMatrix(metaclasses);
		this.printMatrix(matrix);
		HCCalculator hcCalculator = new HCCalculator(project);
		ProjectManagementServices.refreshProject(project);
		
		hcCalculator.performHierarhicalDomainsAnalysis(matrix, metaclasses);
		String treeReport = hcCalculator.getJSReport();
		
		this.createReport(project);
		this.createReportData(treeReport, project);
		
		ProjectManagementServices.refreshProject(project);
		return "DONE...";
	}
	
	/**
	 * Filters the list of eclassifiers by returning only those which are eclasses. 
	 * @param eClassifiers
	 * @return
	 */
	public List<EClass> filterEClasses(EPackage ePackage, List<EClass> answer){
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			if(eClassifier instanceof EClass)
				answer.add((EClass)eClassifier);
		}
		for (EPackage subPackage : ePackage.getESubpackages()) {
			this.filterEClasses(subPackage, answer);
		}
		
		return answer;
	}
	
	/**
	 * Creates the HTML file with the report that displays the commonalities among the set of DSLs. 
	 * @param languages
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void createReport(IProject project) throws URISyntaxException, IOException{
		URL path = Platform.getBundle("fr.inria.diverse.puzzle.metrics").getEntry("/data/" + REPORT_PATH_HIERARCHICAL_DOMAIN_ANALYSIS);
        File file = new File(FileLocator.resolve(path).toURI());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String content = "";
        String currentLine = br.readLine();
        while(currentLine != null){
        	content += currentLine + "\n";
        	currentLine = br.readLine();
        }
        br.close();
        
        File fileReport = new File(project.getLocation().toString() + "/reports/" + REPORT_PATH_HIERARCHICAL_DOMAIN_ANALYSIS );
		if(!fileReport.exists())
			fileReport.createNewFile();
		PrintWriter outRileReport = new PrintWriter( fileReport );
		outRileReport.print(content);
		outRileReport.close();
	}
	
	/**
	 * Creates the .js files containing the data needed by report that displays the commonalities among the set of DSLs. 
	 * @param languages
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void createReportData(String treeReport, IProject project) throws Exception {
		File generalMetrics = new File(project.getLocation().toString() + "/reports/libs/lib/hierarchical-analysis.js" );
		if(!generalMetrics.exists())
			generalMetrics.createNewFile();
		PrintWriter outMetrics = new PrintWriter( generalMetrics );
		outMetrics.print(treeReport);
		outMetrics.close();
	}
	
	private void printMatrix(double[][] matrix){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
}