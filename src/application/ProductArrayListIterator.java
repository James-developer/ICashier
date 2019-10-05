package application;

import java.util.ArrayList;

public class ProductArrayListIterator implements ProductIterator {


	ArrayList<StoreProduct>products;
	int position = 0;
	
	
	public ProductArrayListIterator(ArrayList<StoreProduct> products) {

		this.products = products;
	}
	
	


	public boolean hasNext() {
		if (position >= products.size()) {
			return false;
		} else {
			return true;}
		
	}


	public StoreProduct next() {
		StoreProduct product = products.get(position);
		position++;
		return product;
	}

	
}
