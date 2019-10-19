package application;

public class CashierDrawerProxy implements GetDrawerInfo{

	@Override
	public DrawerState getDrawerState() {
		CashierDrawer cashDrawer = new CashierDrawer();
		return cashDrawer.getDrawerState();
	}

	@Override
	public void displayBalance(double balance) {
		System.out.print("Your total balance is: "  + balance);		
	}

}
