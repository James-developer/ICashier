package application;

public class Return implements Command{

	private Cashier customer;
	
	public Return(Cashier customer) {
		this.customer = customer;
	}
	@Override
	public void execute() {
		customer.RequestReturn();
	}

}
