/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import banking.Account;
import banking.Bank;
import banking.Customer;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
/**
 * @author David
 *
 */
public class CustomerTestSuite extends Account{
	public CustomerTestSuite(Customer cust, double initialBalance, String accountDescription) {
		super(cust, initialBalance, accountDescription);
		// TODO Auto-generated constructor stub
	}

	private Bank bank;
	private String customerId;
    private String lastName;
    private String firstName;
    private SortedSet<Account> customerAccounts = new TreeSet<>();
    private Customer customer1;
    private double initialBalance;
    private String custDesc1;
    private String custName1;
    private Account account1;
	
	@Before
	public void init() {
		bank = new Bank("DA Banking");
		lastName = "Alvarez";
		firstName = "David";
		initialBalance = 100.15;
		custDesc1 = "Test Account";
		customer1 = new Customer(bank, lastName, firstName);
		custName1 = customer1.getFirstName();
		
	}

	/**
	 * Test method for {@link banking.Customer#getCustomerAccounts()}.
	 */
	@Test
	public void testGetCustomerAccounts() {
		
	}

	/**
	 * Test method for {@link banking.Customer#ytdFees()}.
	 */
	@Test
	public void testYtdFees() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Customer#ytdInterest()}.
	 */
	@Test
	public void testYtdInterest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Customer#addSavingsAccount(double, java.lang.String)}.
	 */
	@Test
	public void testAddSavingsAccount() {
		final double initialBalance = 100.12;
		final String desc = "This is a test Account";
		
		customerAccounts.add(customer1.addSavingsAccount(initialBalance, desc));
		int size = customerAccounts.size();
		assertEquals(size, hasSize(1));
	}

	/**
	 * Test method for {@link banking.Customer#removeAccount(java.lang.String)}.
	 */
	@Test
	public void testRemoveAccount() {
		
	}

	/**
	 * Test method for {@link banking.Customer#getAccount(java.lang.String)}.
	 */
	@Test
	public void testGetAccount() {
		fail("Not yet implemented");
	}

}
