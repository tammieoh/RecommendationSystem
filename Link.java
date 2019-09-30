package RecommendationSystem;

public class Link {

	public Product p1;
	public Product p2;
	public double weight;
	
	public Link(Product p1, Product p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	public void setWeight(double weight) { 
		this.weight = weight; 
	}  
	
	public String toString() { 
		return "[" + p1.name + " - " + p2.name + "-" + this.weight +  "]";
	}
	// add a link between two products
	
	// remove a link between two products
}
