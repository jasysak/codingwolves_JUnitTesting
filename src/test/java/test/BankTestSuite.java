package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import banking.Account;
import banking.Bank;
import banking.Customer;

/**
 * @author David
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
	 * Test method for {@link banking.Bank#addAccountWizard()}.
	 */
	@Test
	public void testAddAccountWizard() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Bank#getAllAccounts()}.
	 */
	@Test
	public void testGetAllAccounts() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Bank#addCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testAddCustomer() {
		final String customerid;
		customerid = bank.addCustomer(cust1LastName, cust1FirstName);
		customers.put(customerid, customer1);
		String testResult = customers.get(customerid).getFirstName();
		
		assertEquals(customers.size(), 1);
		assertEquals(testResult, cust1FirstName);
	}

	/**
	 * Test method for {@link banking.Bank#removeCustomer(java.lang.String)}.
	 */
	@Test
	public void testRemoveCustomer() {
		final String customerid;
		customerid = bank.addCustomer(cust1LastName, cust1FirstName);
		customers.put(customerid, customer1);
		bank.removeCustomer(customerid);
		
		String testResult = customers.get(customerid).getFirstName();
		
		assertEquals(testResult, null);
	}

	/**
	 * Test method for {@link banking.Bank#getAllCustomers()}.
	 */
	@Test
	public void testGetAllCustomers() {
		allCustomers = bank.getAllCustomers();
		
		
	}

	/**
	 * Test method for {@link banking.Bank#getCustomer(java.lang.String)}.
	 */
	@Test
	public void testGetCustomerString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Bank#getCustomer(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetCustomerStringString() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link banking.Bank#getCustomersAccounts(java.lang.String)}.
	 */
	@Test
	public void testGetCustomersAccounts() {
		fail("Not yet implemented");
	}

}
