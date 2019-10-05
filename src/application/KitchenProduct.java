package application;

import java.util.ArrayList;

public class KitchenProduct implements Product {

	ArrayList<StoreProduct> storeProducts;
	
	public KitchenProduct() {
		
		storeProducts = new ArrayList<StoreProduct>();
		
		addProduct("Microwave",89.99,24);
		addProduct("Oven",129.99,12);
		addProduct("Glass Set",9.99,211);
		addProduct("Table Set",69.99,34);
		addProduct("Shelter",29.99,54);
		addProduct("Plate Set",19.99,64);
		addProduct("Spoon Set",9.99,47);
		addProduct("Rug Small",9.99,241);
		addProduct("Rug Medium",19.99,21);
		addProduct("Rug Large",29.99,22);
		addProduct("Pan Set",39.99,36);
		addProduct("Tea-Pot Set",19.99,12);
		addProduct("Tefal",29.99,45);
		addProduct("Mixer",69.99,78);
	}
	
	
	public void addProduct(String name, double price, int amount) {
		StoreProduct kitchen = new StoreProduct(name,price,amount);
		storeProducts.add(kitchen);
	}

	public ArrayList<StoreProduct> getKitchenProducts() {
		return storeProducts;
	}
	
	public ProductIterator createIterator() {
		
		return new KitchenProductIterator(storeProducts);
	}
	 
	public String toString() {
		return "Kitchen Products ";
	}
}
