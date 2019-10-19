package application;

public class Purchase implements Command {
	
	private Cashier customer;
	
	public Purchase(Cashier customer) {
		this.customer = customer;
	}
	@Override
	public void execute() {
		customer.RequestPurchase();
	}

}
