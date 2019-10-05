package application;

public class StoreProduct {

	String name;
	int amount;
	double price;
	
	public StoreProduct(String name, double price, int amount) {
	
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	


	public String getName() {
		return name;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public double getPrice() {
		return price;
	}
}
