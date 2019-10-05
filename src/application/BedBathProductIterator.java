package application;

import java.util.ArrayList;

public class BedBathProductIterator implements ProductIterator {

	ArrayList<StoreProduct> products;
	int position = 0;
	
	
	public BedBathProductIterator(ArrayList<StoreProduct> products) {
	
		this.products = products;
	}


	public boolean hasNext() {
		if (position >= products.size()) {
			return false;
		} else {
			return true;
		}
	}

	
	public StoreProduct next() {
		StoreProduct storeProduct = products.get(position);
		position++;
		return storeProduct;
	}

}
