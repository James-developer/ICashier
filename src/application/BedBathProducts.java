package application;

import java.util.ArrayList;


public class BedBathProducts implements Product {

	ArrayList<StoreProduct> storeProducts;
	
	public BedBathProducts() {
		storeProducts = new ArrayList<StoreProduct>();
		
		addProduct("Pillow Set",22.99,200);
		addProduct("Matress Twin",223.99,50);
		addProduct("Matress King", 323.00,50);
		addProduct("Matress Queen",423.99,50);
		addProduct("Matress Full",300.00,50);
		addProduct("Bed Frame Alpha", 99.99,57);
		addProduct("Bed Frame Beta",199.00,56);
		addProduct("Lights blue",12.45,12);
		addProduct("Towell Set Aroma", 12.00,500);
		addProduct("Jakuzi Set", 295.00,300);
		addProduct("SHower Curtain",2.50,200);
		addProduct("Rug Softy",45.00,50);
		
		
		
	}
	
	public boolean addProduct (String name, double price, int amount ) {
		StoreProduct bedBath = new StoreProduct(name,price,amount);
		storeProducts.add(bedBath);
		return true;
	}
	
	public ArrayList<StoreProduct> getBedBathProducts(){
		return storeProducts;
	}
	
	public ProductIterator createIterator() {
		return new BedBathProductIterator(storeProducts);
	}

}
