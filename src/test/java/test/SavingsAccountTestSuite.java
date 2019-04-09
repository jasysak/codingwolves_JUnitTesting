/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import banking.Account;
import banking.Bank;
import banking.Customer;
import banking.SavingsAccount;

/**
 * @author David
 *
 */
public class SavingsAccountTestSuite {
	private final Map<String, Customer> customers = new HashMap<>();
	private final SortedSet<Account> customerAccounts = new TreeSet<>();
	private Bank bank;
	private String customerId;
    private String lastName;
    private String firstName;
	private Customer customer1;
	private double initialBalance;
    private String custDesc1;
	private SavingsAccount savAccou;
	
	@Before
	public void init() {
		lastName = "Alvarez";
		firstName = "David";
		bank = new Bank("DA Banking");
		initialBalance = 100.15;
		custDesc1 = "Test Account";
		customer1 = new Customer(bank, lastName, firstName);
		savAccou = new SavingsAccount(customer1, initialBalance, custDesc1);
	}
	/**
	 * Test method for {@link banking.SavingsAccount#SavingsAccount(banking.Customer, double, java.lang.String)}.
	 */
	@Test
	public void testSavingsAccountCustomerDoubleString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.SavingsAccount#addInterestTransaction(double)}.
	 */
	@Test
	public void testAddInterestTransaction() {
		fail("Not yet implemented");
	}

}
