package application;
// an interface for proxy pattern for customer seeing
public interface DrawerState {

	String requestMoney();
	String returnMoney();
	void displayBalance(double balance);
	void finishPurchase();
}
