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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
/**
 * @author David Alvarez, 4/10/19
 *
 */
public class CustomerTestSuite {

	private Bank bank;
	private String customerId;
    private String lastName;
    private String firstName;
    private SortedSet<Account> customerAccounts = new TreeSet<>();
    private SortedSet<Account> testGetCustAccoun = new TreeSet<>();
    private Customer customer1;
    private double initialBalance;
    private String custDesc1;
    private String custName1;
	
	@Before
	public void init() {
		bank = new Bank("DA Banking");
		lastName = "Alvarez";
		firstName = "David";
		initialBalance = 100.15;
		custDesc1 = "Test Account";
		customer1 = new Customer(bank, lastName, firstName);
		custName1 = customer1.getFirstName();
		testGetCustAccoun.clear();
	}

	/**
	 * Test method for {@link banking.Customer#getCustomerAccounts()}.
	 */
	@Test
	public void testGetCustomerAccounts() {
		final double initialBalance = 100.12;
		final String desc = "This is a test Account";
		
		customerAccounts.add(customer1.addSavingsAccount(initialBalance, desc));
		testGetCustAccoun = customer1.getCustomerAccounts();
		
		assertThat(testGetCustAccoun.contains(null), is(false));
		assertEquals(testGetCustAccoun.size(), hasSize(1));
	}

	/**
	 * Test method for {@link banking.Customer#ytdFees()}.
	 */
	@Test
	public void testYtdFees() {
		double expectedResult = 155.45;
		double result;
		
		result = customer1.ytdFees();
		
		assertNotNull(result);
		assertEquals(result, expectedResult);
	}

	/**
	 * Test method for {@link banking.Customer#ytdInterest()}.
	 */
	@Test
	public void testYtdInterest() {
		double expectedResult = 100.15;
		double result;
		
		result = customer1.ytdInterest();
		
		assertNotNull(result);
		assertEquals(result, expectedResult);
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
		String test;
		final double initialBalance = 100.12;
		final String desc = "This is a test Account";
		
		test = customer1.addSavingsAccount(initialBalance, desc).getAccountId();
		customer1.removeAccount(test);
		
		//assert
	}

	/**
	 * Test method for {@link banking.Customer#getAccount(java.lang.String)}.
	 */
	@Test
	public void testGetAccount() {
		fail("Not yet implemented");
	}

}
