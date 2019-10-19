package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class DemoTest {

	@Test
	void test_SetMoneyAndGiveMoney() {
		Customer customer = new Customer();
		customer.SetMoney(500.00);
		customer.GiveMoney(150.00);
		double remainingCash = customer.TotalCash();
		assertEquals(350.00, remainingCash);
	}

	@Test
	void test_performPurchase() {
		KitchenProduct kitchenProduct = new KitchenProduct();
		Customer customer = new Customer();
		Cashier cashier = new Cashier();
		cashier.inviteCustomer(customer);
		cashier.operatePurchase(kitchenProduct.storeProducts);
		double balance = cashier.workingWithCustomer.balance;
		assertEquals(10711.00,balance);
	}
	
}
