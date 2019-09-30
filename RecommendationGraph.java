package RecommendationSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RecommendationGraph {

	// keeps a list of Products and the links between products
	
	// ArrayList<Product> products;
	// for each vertex
	// a list of edges mapped to the vertex
	
	HashMap<Product, ArrayList<Link>> products;
	HashMap<String, ArrayList<Product>> categories;
	
	// add a product?
	public void addProduct(Product p) {
		ArrayList<Link> links = new ArrayList<Link>();
		for (Product neighbor : p.neighbors) {
			links.add(new Link(p, neighbor));
		}
		// add the paring of product p with its link to the hashmap
		this.products.put(p, links);
	}
	
	public void addLink(Product p, Link l) {
		// if there is a link between a product add
		// if not, then don't add
		if (products.get(p).contains(l)) {
			// break
		}
		else {
			products.get(p).add(l);
		}
	}
	
	public boolean containsProduct(int id) {
		// if ID matches with Product ID in hashmap, return true
		boolean containProduct = false;
		for (Product key : products.keySet()) {
			if (key.id == id) {
				containProduct = true;
			}
		}
		return containProduct;
	}
	public ArrayList<Double> sortByWeight(int id) {
		// goes through the hash map, finds the ID
		// then, it accesses all the links of the product
		// then sort the products by weight
		// sort it by the top 3 weights
		// return an array list of the sorted weights
		ArrayList<Double> unsortedList = new ArrayList<Double>();
		ArrayList<Double> finalSort = new ArrayList<Double>();
		// we sort the links, placing them into an arraylist
		for (Product key: products.keySet()) { 
			if (key.id == id) { 
				for(int i = 0; i < products.get(key).size(); i++) {
					unsortedList.add(products.get(key).get(i).weight);
				}
			}
		}
		Collections.reverse(unsortedList);
		for(int i = 0; i < 3; i++) {
			finalSort.add(unsortedList.get(i));
		}
		return finalSort;
	}
	public void addCategory(Product p) {
		// if category already exists in the category's hashmap then add
		// if category doesn't exist then look at p's category, look at key.category 
		// if they equal, then add it to the category's hashmap
		// key will be category, and value will be products
		for(Product key : products.keySet()) {
			ArrayList<Product> category1 = new ArrayList<Product>();
		}
		if(categories.containsKey(p.category)) {
			// put the product at the end of the array list of products (the value)
			// go to that key with the corresponding category, and add the product to the array list of values
			ArrayList<Product> listofProducts = new ArrayList<Product>();
			listofProducts = categories.get(p.category);
			listofProducts.add(p);
			categories.put(p.category, listofProducts);
		}
		else {
			// how do you add a product to an array list of values
			ArrayList<Product> listofProducts = new ArrayList<Product>();
			listofProducts.add(p);
			categories.put(p.category, listofProducts);
		}
	}
	public ArrayList<Integer> sortProductbyTotalPurchase(String category) {
		// this takes a category and returns products in sorted order by total purchase
		// look at the hash table with the key of the categories
		// descending order of the total purchase
		// whatever product has the most purchase will be returned first
		ArrayList<Product> products = new ArrayList<Product>();
		ArrayList<Integer> unsortedPurchases = new ArrayList<Integer>();
		ArrayList<Integer> sortedPurchases = new ArrayList<Integer>();
		products = categories.get(category);
		for(int i = 0; i < products.size(); i++) {
			unsortedPurchases.add(products.get(i).totalPurchases);
		}
		Collections.reverse(unsortedPurchases);
		for(int i = 0; i < unsortedPurchases.size(); i++) {
			sortedPurchases.add(unsortedPurchases.get(i));
		}
		return sortedPurchases;
	}
	public Product searchProduct(int id) {
		Product product = null;
		for(Product key : products.keySet()) {
			if(key.id == id) {
				product = key;
			}
		}
		return product;
	}
	public int getIdByName(String name) {
		// method takes a name and returns the id of the product
		int id = 0;
		for(Product key : products.keySet()) {
			if(key.name == name) {
				id = key.id;
			}
		}
		return id;
	}
	public void printGraph() {
		System.out.println();
	}
	public void printCategory() {
		System.out.println();
	}
}
