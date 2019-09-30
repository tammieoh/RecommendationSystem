package RecommendationSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyRecommendation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RecommendationGraph graph = new RecommendationGraph();
		File file = new File("/Users/tammieoh/Desktop/products.csv");
		
		scanProducts(file, graph);
		scanLinks(file, graph);

		//graph.printGraph();
		
		//graph.printCategory();

		Scanner scan = new Scanner (System.in);
		System.out.println("Enter a product: ");
		String prodName = scan.nextLine();
		if (graph.getIdByName(prodName) == -1) {
			System.out.println("No product found.");
		}
		else {
			System.out.println("Here is your product");
			// how to access the product?
		}
	}
	
	//Because Links can't be added until all the products are known, two scans are made.
	//The first to scan all the product info into nodes, and the second to scan all link data.
	public static void scanProducts(File productFile, RecommendationGraph graph){
		Scanner scanner;
		try {
			scanner = new Scanner(productFile);
			
			while (scanner.hasNextLine()){
				
				String line = scanner.nextLine();
				//Delimit the line by comma
				String[] splitLine = line.split(",");
				
				//Pull the first four values from the line to create a ProductNode
				int id = Integer.parseInt(splitLine[0]);
				String name = splitLine[1];
				String category = splitLine[2];
				int numBought = Integer.parseInt(splitLine[3]);
				
				//Create the node and add it to the graph
				Product product = new Product(id, name, category, numBought);
				// how to add product to the graph?

				
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void scanLinks(File linkFile, RecommendationGraph graph){
		Scanner scanner;
		try {
			scanner = new Scanner(linkFile);
			
			while (scanner.hasNextLine()){
				
				String line = scanner.nextLine();
				String[] splitLine = line.split(",");
				
				//ID of the product whose links are being scanned
				int currentProdID = Integer.parseInt(splitLine[0]);
				
				int lineLength = splitLine.length;
				//Link data begins at column 4 (5th column).
				
				//For every pair of values in the line (from the 5th column onward):
				for(int col=4; col < lineLength; col +=2){
					int linkedID = Integer.parseInt(splitLine[col]);
					double linkedWeight = Double.parseDouble(splitLine[col+1]);
					
					Product currentNode = graph.searchProduct(currentProdID);
					Product linkedNode = graph.searchProduct(linkedID);
					
					//Add link to the ReccomendationGraph
					Link newLink = new Link(currentNode, linkedNode);
					newLink.setWeight(linkedWeight);
					//System.out.println(newLink.toString());
					// how to add to the graph? How to update currentNode?
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}