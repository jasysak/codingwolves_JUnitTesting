
package test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Before;
import org.junit.Test;

import banking.Bank;
import banking.Account;
import banking.Customer;
import banking.SavingsAccount;

/*
 * BankTest.java 
 * 
 * for COP 2805C JUnit Testing, Project #6
 * 
 * @author Jason Sysak
 * 
 * codingwolves team:
 * David Alvarez
 * Reubin George
 * Erin Hochstetler
 * Jason Sysak
 * 
 * NOTE Much of this code is based on D. Alvarez's work on this project. Since I did not know
 * WTF I was doing, I reviewed his code and only then could I write much of this. I feel as 
 * though we were not provided adequate instruction or example code to successfully complete
 * this project at the time it was assigned. Perhaps a few "introductory mini-projects" on 
 * JUnit would have been a HUGE help. It was VERY difficult for me to even start this until I
 * had some example code to "go-by". Further, I would suggest that in the "real world" to write
 * JUnit tests "from scratch" as I initially tried to do on this project is very rarely the case.
 * That is, when writing a new set of JUnit tests, one likely has some similar code to use as a
 * starting point. Had this been offered or provided to students, it would likely have been
 * a huge help in getting started on this project.
 * END RANT
 * 
 * EDIT:
 * After carefully reviewing David's code, this project becomes much easier. 
 */

public class BankTest {
	// will definitely need some Sets of Account and Customer
	SortedSet<Account> accountsSet = new TreeSet<Account>();
	SortedSet<Customer> customersSet = new TreeSet<Customer>();
	// will need a List of Customer, maybe Account too
	List<Account> accountsArrList = new ArrayList();
	List<Customer> customersArrList = new ArrayList();
	
	// will need a bank object
	Bank bank;
	
	// will need more than one customer object, and Strings FName/LName to fill
	// appropriate fields for creating
	Customer cust1;
	String cust1FName;
	String cust1LName;
	Customer cust2;
	String cust2FName;
	String cust2LName;
	
	// we might need a Map<Customer, Set<Account>> for cases where a customer has 
	// many accounts. I'll add this later if it's needed.
	
	// from Bank.java
	 private final Map<String, Customer> customersMap = new HashMap<>();
	
	
	@Before
	public void initializeTests() {
		// set up a few vars to contain valid data for use in tests
		bank = new Bank("Some Random Bank (Test)");
		cust1FName = "Phil";
		cust1LName = "Potts";
		cust2FName = "Carrie";
		cust2LName = "Greene";
		cust1 = new Customer(bank, cust1FName, cust1LName);
		cust2 = new Customer(bank, cust2FName, cust2LName);	
	}
	
	@Test
	public void testAddAccountWizard() {
		// no idea WTF this method does
		// it probably should be tested though...somehow
	}

	@Test
	public void testGetAllAccounts() {
		double balance1 = 1200.50;
		String desc1 = "Test Account 1";
		double balance2 = 2100.50;
		String desc2 = "Test Account 2";
		SavingsAccount savingsAccount1 = cust1.addSavingsAccount(balance1, desc1);
		SavingsAccount savingsAccount2 = cust2.addSavingsAccount(balance2, desc2);
		accountsSet = bank.getAllAccounts();
		// this is a most basic test. It should pretty much always pass.
		assertThat(accountsSet, IsCollectionContaining.hasItems(savingsAccount1, savingsAccount2));
	}

	@Test
	public void testAddCustomerWizard() {
		// no idea WTF this method does
		// it probably should be tested though...somehow
	}

	@Test
	public void testAddCustomer() {
		String custID1 = bank.addCustomer(cust1LName, cust1FName);
		String custID2 = bank.addCustomer(cust2LName, cust2FName);
		customersMap.put(custID1, cust1);
		customersMap.put(custID2,  cust2);
		
		// Next 3 lines from David's code:
		String testResult = customersMap.get(custID1).getFirstName();
		assertEquals(customersMap.size(), 2);
		assertEquals(testResult, cust1FName);
	}

	@Test
	public void testRemoveCustomer() {
		String custID1 = bank.addCustomer(cust1LName, cust1FName);
		String custID2 = bank.addCustomer(cust2LName, cust2FName);
		customersMap.put(custID1, cust1);
		customersMap.put(custID2,  cust2);
		customersMap.remove(custID1);
		
		String testResult = customersMap.get(custID2).getFirstName();
		assertEquals(customersMap.size(), 1);
		assertEquals(testResult, cust2FName);
	}

	@Test
	public void testGetAllCustomers() {
		String custID1 = bank.addCustomer(cust1LName, cust1FName);
		String custID2 = bank.addCustomer(cust2LName, cust2FName);
		customersMap.put(custID1, cust1);
		customersMap.put(custID2,  cust2);
		
		customersSet = bank.getAllCustomers();
		
		assertThat(customersSet, IsCollectionContaining.hasItems(cust1, cust2));
		
	}

	@Test
	public void testGetCustomerString() {
		String testCust = cust1.getCustomerId();
		Customer testResult = bank.getCustomer(testCust);
		
		assertEquals(testResult.getCustomerId(), cust1.getCustomerId());
	}

	@Test
	public void testGetCustomerStringString() {
		customersArrList = bank.getCustomer(cust1LName, cust1FName);
		assertNotNull(customersArrList);
	}

	@Test
	public void testGetCustomersAccounts() {
		String testCust = cust1.getCustomerId();
		accountsArrList = bank.getCustomersAccounts(testCust);
		assertNotNull(accountsArrList);
	}

}
