package test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.Arrays;
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
 * @author David Alvarez, 4/10/19
 *
 */
public class BankTestSuite {
	private SortedSet<Account> allAccounts = new TreeSet<>();
	private SortedSet<Customer> testAllCustomers;
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
		fail("Not yet implemented");
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
		testAllCustomers.add(customer1);
		testAllCustomers.add(customer2);
		allCustomers = bank.getAllCustomers();
		
		//assertThat(testAllCustomers, is(allCustomers));
		
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
		final String customerid2;
		customerid1 = bank.addCustomer(cust1LastName, cust1FirstName);
		customerid2 = bank.addCustomer(cust2LastName, cust2FirstName);
		customers.put(customerid1, customer1);
		customers.put(customerid2, customer2);
		
		accounts = bank.getCustomersAccounts(customerid1);
		
	}

}
