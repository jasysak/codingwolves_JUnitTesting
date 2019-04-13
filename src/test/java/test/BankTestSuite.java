package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import banking.Account;
import banking.Bank;
import banking.Customer;
import banking.SavingsAccount;

/**
 * @author David Alvarez, 4/10/19
 *
 */
public class BankTestSuite {
	private SortedSet<Account> allAccounts = new TreeSet<>();
	private List<Account> accounts = new ArrayList();
	private SortedSet<Customer> allCustomers = new TreeSet<>();
	private List<Customer> customer = new ArrayList();
	private final Map<String, Customer> customers = new HashMap<>();
	private Bank bank;
	private Customer customer1;
	private String cust1FirstName;
	private String cust1LastName;
	private Customer customer2;
	private String cust2FirstName;
	private String cust2LastName;
	
	@Before
	public void init() {
		bank = new Bank("DA Banking");
		cust1LastName = "Alvarez";
		cust1FirstName = "David";
		cust2LastName = "Mercury";
		cust2FirstName = "Freddie";
		customer1 = new Customer(bank, cust1LastName, cust1FirstName);
		customer2 = new Customer(bank, cust2LastName, cust2FirstName);
		customers.clear(); 
	}

	/**
	 * Test method for {@link banking.Bank#getAllAccounts()}.
	 */
	@Test
	public void testGetAllAccounts() {
		final double initialBalance1 = 56.12;
		final String desc1 = "This is a test Account";
		final double initialBalance2 = 75.13;
		final String desc2 = "This is a test Account";
		SavingsAccount savingAccoun1 = customer1.addSavingsAccount(initialBalance1, desc1);
		SavingsAccount savingAccoun2 = customer2.addSavingsAccount(initialBalance2, desc2);
		
		allAccounts = bank.getAllAccounts();
		
		assertThat(allAccounts, IsIterableContainingInOrder.contains(savingAccoun1, savingAccoun2));
	}

	/**
	 * Test method for {@link banking.Bank#addCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddCustomer() {
		final String customerid1;
		final String customerid2;
		customerid1 = bank.addCustomer(cust1LastName, cust1FirstName);
		customerid2 = bank.addCustomer(cust2LastName, cust2FirstName);
		customers.put(customerid1, customer1);
		customers.put(customerid2, customer2);
		String testResult = customers.get(customerid1).getFirstName();
		
		assertEquals(customers.size(), 2);
		assertEquals(testResult, cust1FirstName);
	}

	/**
	 * Test method for {@link banking.Bank#removeCustomer(java.lang.String)}.
	 */
	@Test
	public void testRemoveCustomer() {
		final String customerid1;
		customerid1 = bank.addCustomer(cust1LastName, cust1FirstName);
		customers.put(customerid1, customer1);
		bank.removeCustomer(customerid1);
		
		String testResult = customers.get(customerid1).getFirstName();
		
		assertEquals(testResult, null);
	}

	/**
	 * Test method for {@link banking.Bank#getAllCustomers()}.
	 */
	@Test
	public void testGetAllCustomers() {
		final String customerid1;
		final String customerid2;
		customerid1 = bank.addCustomer(cust1LastName, cust1FirstName);
		customerid2 = bank.addCustomer(cust2LastName, cust2FirstName);
		customers.put(customerid2, customer2);
		customers.put(customerid1, customer1);
		allCustomers = bank.getAllCustomers();
		
		assertThat(allCustomers, IsIterableContainingInOrder.contains(customer1, customer2));
	}

	/**
	 * Test method for {@link banking.Bank#getCustomer(java.lang.String)}.
	 */
	@Test
	public void testGetCustomerString() {
		String testcustid = customer1.getCustomerId();
		final Customer result;

		result = bank.getCustomer(testcustid);
		
		assertEquals(result.getCustomerId(), customer1.getCustomerId());
	}

	/**
	 * Test method for {@link banking.Bank#getCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetCustomerStringString() {
		customer = bank.getCustomer(cust1LastName, cust1FirstName);
		
		assertThat(customer.contains(null), is(false));
		assertEquals(customer.get(0).getFirstName(), cust1FirstName);
	}

	/**
	 * Test method for {@link banking.Bank#getCustomersAccounts(java.lang.String)}.
	 */
	@Test
	public void testGetCustomersAccounts() {
		final String customerid1;
		final double initialBalance = 56.12;
		final String desc = "This is a test Account";
		customerid1 = bank.addCustomer(cust1LastName, cust1FirstName);
		customers.put(customerid1, customer1);
		SavingsAccount savingAccoun = customer1.addSavingsAccount(initialBalance, desc);
		
		accounts = bank.getCustomersAccounts(customerid1);
		
		assertThat(accounts.contains(null), is(false));
		Assert.assertTrue(accounts.contains(savingAccoun));
	}

}
