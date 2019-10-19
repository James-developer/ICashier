package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {

		BedBathProducts bedBathProduct = new BedBathProducts();
		KitchenProduct kitchenProduct = new KitchenProduct();
		
		ArrayList<StoreProduct> bedBathProducts = bedBathProduct.getBedBathProducts();
		ArrayList<StoreProduct> kitchenProducts = kitchenProduct.getKitchenProducts();
		
		Queue<Customer> customers = new LinkedList<Customer>();
		
		for (int a = 0; a < 5; a++) {
			Customer customer = new Customer();
			customer.totalCash = 5000.00;
			Random random = new Random();
			
			for(int b = 0; b < 4; b++) {
				StoreProduct product = bedBathProducts.get(random.nextInt(2));
				product.amount = random.nextInt(5-1)+1;
				customer.addProduct(product);;
			}
			for (int c = 0; c < 4; c++) {
				StoreProduct product = kitchenProducts.get(random.nextInt(3));
				product.amount = random.nextInt(5-1)+1;
				customer.addProduct(product);
			}
			customers.add(customer);
		}
		
		// code to determine line
		StoreQueue storeLine = new StoreQueue();
		NoQueueState NoLine = new NoQueueState();
		QueueState hasLine = new QueueState();
		
		Cashier cashier = new Cashier();
		Scanner scan = new Scanner(System.in);
		
		while(!customers.isEmpty()) {
			
			if(customers.size()<=0) {
				NoLine.Queue(storeLine);
			} else {
				hasLine.Queue(storeLine);
			}
			// call next customer
			Customer customer =pop(customers);
			cashier.inviteCustomer(customer);;
			Purchase purchase = new Purchase(cashier);
			Return returnItem = new Return(cashier);
			System.out.println("");
			System.out.println("\nHello" + "\nReturn or Purchase?" + "\n(Write exactly 'purchase' or 'return')");
		
			String input = scan.nextLine();
			
			// purchase operation
			
			if (input.equals("purchase")) {
				cashier.workingWithCustomer.Order(purchase);
				cashier.workingWithCustomer.MakeOrder();
				System.out.println();
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println(dateFormat.format(cal.getTime()));
				System.out.println();
				
				cashier.operatePurchase(cashier.workingWithCustomer.productList);
				System.out.println();
				
				CashierDrawerProxy cashierDrawerProxy =new CashierDrawerProxy();
				cashierDrawerProxy.getDrawerState();
				cashierDrawerProxy.displayBalance(cashier.workingWithCustomer.balance);
				CashierDrawer cashierDrawer = new CashierDrawer();
				cashierDrawer.getRequestMoneyState();
				System.out.println(cashierDrawer.requestMoney());
				
				double cash = customer.GiveMoney(cashier.workingWithCustomer.balance);
				System.out.println("\nPayment from Customer: " + cash);
				
				// return change
				int change = (int) (Math.ceil((cash - cashier.workingWithCustomer.balance) * 100));
				System.out.println("\nTotal amount of change to give: " + (cash - cashier.workingWithCustomer.balance));
				
				int dollars = Math.round((int) change / 100);
				change = change % 100;
				int quarters = Math.round((int) change / 25);
				change = change % 25;
				int dimes = Math.round((int) change / 10);
				change = change % 10;
				int nickels = Math.round((int) change / 5);
				change = change % 5;
				int pennies = Math.round((int) change / 1);

				System.out.println("Dollars: " + dollars);
				System.out.println("Quarters: " + quarters);
				System.out.println("Dimes: " + dimes);
				System.out.println("Nickels: " + nickels);
				System.out.println("Pennies: " + pennies);
				
				double totalCashInDrawer = cashierDrawer.getCashInDrawer() + cash;
				cashierDrawer.updateCashInDrawer(totalCashInDrawer);
				cashierDrawer.getRequestMoneyState();
				System.out.println(cashierDrawer.returnMoney());
				cashierDrawer.finishPurchase();
				
				// return operation
			} else if (input.equals("return")){
				
				cashier.workingWithCustomer.Order(returnItem);
				cashier.workingWithCustomer.MakeOrder();
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				System.out.println(dateFormat.format(cal.getTime()));
				
				cashier.operatePurchase(cashier.workingWithCustomer.productList);
				CashierDrawerProxy cashierDrawerProxy = new CashierDrawerProxy();
				cashierDrawerProxy.displayBalance(cashier.workingWithCustomer.balance);
				
				int change = (int) (Math.ceil((cashier.workingWithCustomer.balance) * 100));
				System.out.println("\nTotal amount of change to give: " + cashier.workingWithCustomer.balance);

				int dollars = Math.round((int) change / 100);
				change = change % 100;
				int quarters = Math.round((int) change / 25);
				change = change % 25;
				int dimes = Math.round((int) change / 10);
				change = change % 10;
				int nickels = Math.round((int) change / 5);
				change = change % 5;
				int pennies = Math.round((int) change / 1);

				System.out.println("Dollars: " + dollars);
				System.out.println("Quarters: " + quarters);
				System.out.println("Dimes: " + dimes);
				System.out.println("Nickels: " + nickels);
				System.out.println("Pennies: " + pennies);
				
				CashierDrawer cashierDrawer = new CashierDrawer();
				cashierDrawer.getRequestMoneyState();
				System.out.println(cashierDrawer.returnMoney());
				
				double cash = customer.GiveMoney(cashier.workingWithCustomer.balance);
				double totalCashInDrawer = cashierDrawer.getCashInDrawer() + cash;
				cashierDrawer.updateCashInDrawer(totalCashInDrawer);

				cashierDrawer.finishPurchase();
				
				// unknown input
			} else {System.out.println("Unknown Input");}
		}
	
	}

	private static Customer pop(Queue<Customer> customers) {
		
		return customers.remove();
	}

}
