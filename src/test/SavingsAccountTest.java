package test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

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
import banking.SavingsAccount;

/*
 * SavingsAccountTest.java 
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
public class SavingsAccountTest {
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
	double initBalance = 1000.1;
	SavingsAccount cust1Account1;
	SavingsAccount cust2Account1;
	
	
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
		cust1Account1 = new SavingsAccount(cust1, initBalance, "Test Account Customer 1");
		cust2Account1 = new SavingsAccount(cust2, initBalance, "Test Account Customer 2");
	}

	@Test
	public void testDeposit() {
		double depositAmount = 100.5;
		cust1Account1.deposit(depositAmount);
		assertEquals(cust1Account1.getBalance(), (initBalance + depositAmount), 0);
	}

	@Test
	public void testWithdraw() {
		double withdrawAmount = 100.5;
		cust1Account1.withdraw(withdrawAmount);
		assertEquals(cust1Account1.getBalance(), (initBalance - withdrawAmount), 0);
	}

	@Test
	public void testSavingsAccountCustomerDoubleString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSavingsAccountCustomerDoubleStringDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddInterestTransaction() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDefaultInterestRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDefaultInterestRate() {
		fail("Not yet implemented");
	}

}
