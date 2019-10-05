package application;

public class productArrayIterator implements ProductIterator {
	
	StoreProduct[] products;
	int position = 0;
	
	
	
	public productArrayIterator(StoreProduct[] products) {

		this.products = products;
		
	}
	
	public StoreProduct next() {
		StoreProduct storeProduct = products[position];
		position++;
		return storeProduct;
	}

	
	public boolean hasNext() {
		
		if (position >= products.length || products[position] == null) {
			return false;
		} 
		else {	
			return true;}
	
	}

}
