package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import banking.Account;
import banking.Bank;
import banking.Customer;
import banking.SavingsAccount;

/*
 * CustomerTest.java 
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
*/

/* methods in Customer not EXPLICITLY tested:
 * 
 * Customer(Bank, String, String) - constructor
 * getBank() - simple getter
 * getCustomerId() - simple getter
 * getLastName() - simple getter
 * getFirstName ()  - simple getter
 * All @Override methods: toString, hashCode, equals, compareTo
 * 
 */
class CustomerTest {
	
	// will definitely need some Sets of Account and Customer
	SortedSet<Account> accountsSet = new TreeSet<Account>();
	SortedSet<Customer> customersSet = new TreeSet<Customer>();
	// will need a List of Customer, maybe Account too
	List<Account> accountsArrList = new ArrayList();
	List<Customer> customersArrList = new ArrayList();
		
	// might need a bank object
	Bank bank;
		
	// will need more than one customer object, and Strings FName/LName to fill
	// appropriate fields for creating
	Customer cust1;
	String cust1FName;
	String cust1LName;
	Customer cust2;
	String cust2FName;
	String cust2LName;
	
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
	void testCustomer() {
		// may add a test here from David's code if I run out of time to write one of my own
	}

	@Test
	void testGetCustomerAccounts() {
		customersSet.add(cust1);
		assertNotNull(customersSet);
	}

	@Test
	void testYtdFees() {
		// maybe a test for a specific Fees value should be added?
		// it is reasonable that ytdFees = 0.0 may be true for a valid
		// working scenario
		assertTrue(cust1.ytdFees() > 0.0);
		
		// the following assertion will pass every time since ytdFees() returns 0.0
		// assertNotNull(cust1.ytdFees());
	}

	@Test
	void testYtdInterest() {
		// maybe a test for a specific Interest value should be added?
		// it is reasonable that ytdInterest = 0.0 may be true for a valid
		// working scenario
		assertTrue(cust1.ytdInterest() > 0.0);
		
		// the following assertion will pass every time since ytdInterest() returns 0.0
		// assertNotNull(cust1.ytdInterest());
	}

	@Test
	void testAddSavingsAccount() {
		double initBal = 1000.5;
		String desc = "Test Account CustomerTest";
		assertNotNull(cust1.addSavingsAccount(initBal, desc));
	}

	@Test
	void testRemoveAccount() {
		String custID = cust1.getCustomerId();
		double initBal = 1000.5;
		String desc = "Test Account CustomerTest";
		accountsArrList.add(cust1.addSavingsAccount(initBal, desc));
		cust1.removeAccount(custID);
		assertNull(accountsArrList);
		// not sure if the above 3 lines will actually work...
	}

	@Test
	void testGetAccount() {
		double initBal = 1000.5;
		String desc = "Test Account CustomerTest";
		SavingsAccount test = cust1.addSavingsAccount(initBal, desc);
		// not sure the accountsSet is really needed here, but
		// since we have it, we can do an assert on the Set
		accountsSet.add(test);
		assertNotNull(cust1.getAccount(test.getAccountId()));
		// following assert based on comment above - but does it actually
		// tell us anything of value?
		assertThat(accountsSet, IsCollectionContaining.hasItems(test));
	}

}
