package application;
import java.util.ArrayList;

public class KitchenProductIterator implements ProductIterator {

	ArrayList<StoreProduct> products;
	int position = 0;
	
	
	public KitchenProductIterator(ArrayList<StoreProduct> products) {
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
		StoreProduct product = products.get(position);
		position++;
		return product;
	}

}
