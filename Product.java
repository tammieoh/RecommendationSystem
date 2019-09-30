package RecommendationSystem;

import java.util.ArrayList;

public class Product {

	// instance variables
	
	public String category;
	public int id;
	public int totalPurchases;
	public String name;
	ArrayList<Product> neighbors;
	
	public Product(int id, String name, String category, int totalPurchases) {
		// id name category numBought
		this.category = category;
		this.id = id;
		this.totalPurchases = totalPurchases;
		this.name = name;
		this.neighbors = new ArrayList<>();
	}
	public void addNeighbor(Product p) { 
		this.neighbors.add(p);
	} 
	
	public int getInDegree() { 
		return this.neighbors.size();
	}
	
	public boolean isLinked(Product anotherP) { 
		return this.neighbors.contains(anotherP);
	}
	
	// toString method that returns ID name and Category 
	public String toString() { 
		return this.id + "\t" + this.name + "\t" + this.category + "\t" + this.totalPurchases + "\n";
		// ask someone else for this
	}
	


	
}
