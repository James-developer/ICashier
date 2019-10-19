package application;

import java.util.ArrayList;

public class Cashier {
	Customer workingWithCustomer;
	private double amountCurrent;
	private double amountReceived;
	private double change;
	
	
	
	// to call a customer
	public void inviteCustomer(Customer customer) {
		workingWithCustomer = customer;
	}
	// to request a purchase 
		public void RequestPurchase() {
			System.out.println(" Processing Purchase ...");
		}
	// to make a return
	public void RequestReturn() {
		System.out.println(" Processing Return ...");
	}
	// to get a list of product(s) in storeProduct, to return a balance
	public void operatePurchase(ArrayList<StoreProduct> productList) {
		
		System.out.format("%-11s |","Product");
		System.out.format("%-3s|","Price $");
		System.out.format("%-2s  |", "Qty");
		System.out.format("%n");
		System.out.format("------------------------------------ %n");
		
		for (int i = 0; i < productList.size(); i++) {
			
			System.out.format("%-12s |",productList.get(i).name );
			System.out.format("%-3s  |",productList.get(i).price );
			System.out.format("%-2s  |",productList.get(i).amount);
			System.out.println();
			
			workingWithCustomer.balance += productList.get(i).price * productList.get(i).amount;
		}
	}
	
	
}
