package fr.inria.diverse.generator.pcm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import fr.inria.diverse.dag.generator.GraphGenerator;
import fr.inria.diverse.graph.Arc;
import fr.inria.diverse.graph.Graph;
import fr.inria.diverse.graph.Vertex;

/**
 * Generates a PCM that respects a given dependencies graph. 
 * 
 * @author David Mendez-Acuna
 *
 */
public class PCMGenerator {

	// -------------------------------------------------------
	// Methods
	// -------------------------------------------------------

	/**
	 * Automatically generates a PCM that respects the dependencies specified in the given graph. 
	 * @param graph. Graph containing the dependencies that should be respected. 
	 * @param productsAmount. Amount of desired products. 
	 * @param seed. Random seed for generating the random PCM. 
	 * @param k. K index indicating the amount of root vertex used in the generation. 
	 * @return
	 */
	public String generatePCMs(Graph<Vertex, Arc> graph, int productsAmount, long seed, int k){
		Random generator = new Random(seed);
		int count = 0;
		String PCM = "\"Product\",";
		
		for (Vertex vertex : graph.getVertex()) {
			PCM += "\"" + vertex.getIdentifier() + "\",";
		}
		PCM += "\n";
		int i = 0;
		int productsIterations = productsAmount;
		while(productsIterations > 0){
			
			ArrayList<Vertex> vertexToInclude = new ArrayList<Vertex>();
			
			// Randomly choosing k vertex
			int graphSize = graph.getVertex().size();
			int iterationsK = 1;
			while(iterationsK > 0){
				
				int currentVertexIndex = 0 + (int)(generator.nextDouble() * (graphSize));
				Vertex currentVertex = graph.getVertex().get(currentVertexIndex);
				addDependencies(currentVertex, vertexToInclude);
				iterationsK--;
			}
			
			String currentProduct = "";
			for (int j = 1; j <= graphSize; j++) {
				boolean vertexIncluded = contains(vertexToInclude, ("F" + j));
				
				if(vertexIncluded)
					currentProduct += "\"YES\",";
				else
					currentProduct += "\"NO\",";
			}
			
			if(!exists(currentProduct, PCM) /*&& currentProduct.contains("NO")*/){
				PCM += "\"P" + i + "\",";
				PCM += currentProduct + "\n";
				i++;
				productsIterations--;
			}else{
				count++;
			}
			
			if(count > 900){
				System.out.println("No hay tantos productos como pide!");
				return PCM;
			}
		}
		
		return PCM;
	}

	/**
	 * Returns true if the given product exists in the given PCM. 
	 * @param currentProduct
	 * @param PCM
	 * @return
	 */
	private static boolean exists(String currentProduct, String PCM) {
		String[] products = PCM.split("\n");
		for (String product : products) {
			if(product.endsWith(currentProduct))
				return true;
		}
		return false;
	}

	/**
	 * Returns true if there is a vertex in the given array whose identifier matches with the parameter.
	 * @param array. Array where the vertexIdentifier should be searched.
	 * @param vertexIdentifier. Searched vertex identifier. 
	 * @return
	 */
	private static boolean contains(
			ArrayList<Vertex> array, String vertexIdentifier) {
		for (Vertex dependencyVertex : array) {
			if(dependencyVertex.getIdentifier().equals(vertexIdentifier))
				return true;
		}
		return false;
	}

	/**
	 * Add the dependencies to the given vertex in the array in the parameter. 
	 * @param vertex
	 * @param array
	 */
	private static void addDependencies(Vertex vertex,
			ArrayList<Vertex> array) {
		
		if(!array.contains(vertex))
			array.add(vertex);
		
		for (Arc arc : vertex.getOutgoingArcs()) {
			addDependencies((Vertex) arc.getTo(), array);
		}
	}
	
	public Properties readProperties() throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("parameters.properties");
		prop.load(input);
		input.close();
		return prop;
	}
	
	/**
	 * Generate the pool of instances indicated in the parameters.properties file. 
	 * 
	 * @return
	 * @throws IOException
	 */
	public List<InstanceVO> generateAllPCMs() throws IOException {
		List<InstanceVO> instances = new ArrayList<InstanceVO>();
		
		GraphGenerator graphGenerator = new GraphGenerator();
		Properties properties = this.readProperties();
		int instancesAmount = Integer.parseInt(properties.getProperty("instances-amount"));
		
		int index = 1;
		while(instancesAmount > 0){
			int featuresAmount = Integer.parseInt(properties.getProperty(index + "-features-amount"));
			int productsAmount = Integer.parseInt(properties.getProperty(index + "-products-amount"));
			int chainLenght = Integer.parseInt(properties.getProperty(index + "-chain-lenght"));
			long graphSeed = Long.parseLong(properties.getProperty(index + "-graph-seed"));
			long pcmSeed = Long.parseLong(properties.getProperty(index + "-pcm-seed"));
			
			Graph<Vertex, Arc> graph = graphGenerator.generateGraph("F", featuresAmount, graphSeed, chainLenght);
			
			String[][] adjacencyMatrix = graph.adjacencyMatrix();
			
			for (int i = 0; i < adjacencyMatrix.length; i++) {
				for (int j = 0; j < adjacencyMatrix[0].length; j++) {
					System.out.print(adjacencyMatrix[i][j] + "|");
				}
				System.out.println();
			}
			
			System.out.println();
			System.out.println(graph.toString());

			String openPCM = this.generatePCMs(graph, productsAmount, pcmSeed, 3);
			System.out.println(openPCM);
			System.out.println();
			
			String closedPCM = PCMFillerGenerator.fillPCM(graph, openPCM);
			System.out.println(closedPCM);
			System.out.println();
			
			InstanceVO instance = new InstanceVO(graph, openPCM, closedPCM, featuresAmount, productsAmount);
			instances.add(instance);
			
			instancesAmount--;
			index++;
		}
		
		return instances;
	}
	
	// -------------------------------------------------------
	// Main
	// -------------------------------------------------------

	public static void main(String args[]){
		PCMGenerator generator = new PCMGenerator();
		try {
			generator.generateAllPCMs();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
