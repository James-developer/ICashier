package application;

import java.util.ArrayList;

public class KitchenProduct implements Product {

	ArrayList<StoreProduct> storeProducts;
	
	public KitchenProduct() {
		
		storeProducts = new ArrayList<StoreProduct>();
		
		addProduct("Microwave",89.00,24);
		addProduct("Oven",129.00,12);
		addProduct("Glass Set",9.00,211);
		addProduct("Table Set",69.00,34);
		addProduct("Shelter",29.00,54);
		addProduct("Plate Set",19.00,64);
	
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
