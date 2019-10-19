package application;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	ArrayList<StoreProduct> productList;
	double balance, totalCash;
	
	public Customer(){
		productList = new ArrayList<StoreProduct>();
	}
	
	public void addProduct(StoreProduct product) {
		productList.add(product);
	}
	
	public void SetMoney(double money) {
		totalCash = money;
	}
	
	public double TotalCash() {
		return totalCash;
	}
	
	List<Command> commandList = new ArrayList<Command>();
	
	public void Order(Command order) {
		commandList.add(order);
	}
	
	public void MakeOrder() {
		for(Command order : commandList) {
			order.execute();
		}
		commandList.clear();
	}
	
	public double GiveMoney(double balance) {
		if (balance < totalCash)
		{totalCash = totalCash - balance;}
		int rounded = (int) (((balance + 5)/100) * 100);
		return rounded ;
	}
	
}
