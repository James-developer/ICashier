package application;

public class CashierDrawer implements GetDrawerInfo {

	private DrawerState drawerState;
	private double cashInDrawer = 5000;
	private DrawerState requestCash;
	private DrawerState returnCash;
	
	public String requestMoney() { return "\n Please pay for the purchase"; }
	public String returnMoney() { return "\n Please accept your money"; }
	public void finishPurchase() { System.out.println("\n Thank you, please visit us again..."); }
	
	public DrawerState getRequestMoneyState() { return requestCash; }
	public DrawerState getReturnMoneyState() { return returnCash; }
	
	@Override
	public DrawerState getDrawerState() {
		return drawerState;
	}
	
	@Override
	public void displayBalance(double balance) {
		System.out.print("Your total balance is: "  + balance);
	}
	
	public double getCashInDrawer() { return cashInDrawer; }
	public void updateCashInDrawer(double newCash ) { cashInDrawer = newCash; }

}
