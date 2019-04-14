package test;

import static org.hamcrest.CoreMatchers.is;
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
import banking.SavingsAccount;
import banking.Transaction;
import banking.TransactionType;

/**
 * @author David Alvarez, 4/12/19
 *
 */
public class SavingsAccountTestSuite {
	private final Map<String, Customer> customers = new HashMap<>();
	private final SortedSet<Account> customerAccounts = new TreeSet<>();
	private List<Transaction> transactionList = new ArrayList();
	private Bank bank;
    private String cust1LastName;
    private String cust1FirstName;
	private Customer customer1;
	private double cust1InitialBalance;
    private String cust1Desc;
    private String cust2LastName;
    private String cust2FirstName;
	private Customer customer2;
	private double cust2InitialBalance;
    private String cust2Desc;
	private SavingsAccount savAccoun1;
	private SavingsAccount savAccoun2;
	@Before
	public void init() {
		bank = new Bank("DA Banking");
		cust1LastName = "Alvarez";
		cust1FirstName = "David";
		cust1InitialBalance = 100.15;
		cust1Desc = "Test Account";
		customer1 = new Customer(bank, cust1LastName, cust1FirstName);
		cust2LastName = "Mercury";
		cust2FirstName = "Freddie";
		cust2InitialBalance = 450.15;
		cust2Desc = "Test Account";
		customer2 = new Customer(bank, cust2LastName, cust2FirstName);
		savAccoun1 = new SavingsAccount(customer1, cust1InitialBalance, cust1Desc);
		savAccoun2 = new SavingsAccount(customer2, cust2InitialBalance, cust2Desc);
		transactionList.clear();
	}

	/**
	 * Test method for {@link banking.SavingsAccount#addInterestTransaction(double)}.
	 */
	@Test
	public void testAddInterestTransaction() {
		final double rate = SavingsAccount.getDefaultInterestRate();
		
		savAccoun1.addInterestTransaction(rate);
		transactionList = savAccoun1.getTransactions();
		
		assertThat(transactionList.contains(null), is(false));
		assertEquals(transactionList.get(0).getType(), TransactionType.INTEREST);
	}
	
	/**
	 * Test method for {@link banking.Account#getTransaction(Integer)}.
	 */
	@Test
	public void testGetTransaction() {
		final double rate = SavingsAccount.getDefaultInterestRate();
		
		savAccoun1.addInterestTransaction(rate);
		transactionList = savAccoun1.getTransactions();
		int id = transactionList.get(0).getId();
		Transaction result = savAccoun1.getTransaction(id);
		
		assertEquals(result.getType(), TransactionType.INTEREST);
	}
	
	/**
	 * Test method for {@link banking.Account#deposit(double)}.
	 */
	@Test
	public void testDeposit() {
		final double depositAmoun = 50.00;
		final double result = 150.15;
		savAccoun1.deposit(depositAmoun);
		
		assertEquals(savAccoun1.getBalance(), result);
	}
	
	/**
	 * Test method for {@link banking.Account#withdraw(double)}.
	 */
	@Test
	public void testWithdraw() {
		final double withdrawAmoun = 50.00;
		final double result = 50.15;
		savAccoun1.withdraw(withdrawAmoun);
		
		assertEquals(savAccoun1.getBalance(), result);
	}
	
	/**
	 * Test method for {@link banking.Account#withdraw(double)}.
	 */
	@Test
	public void testInsufficientFundsPenaltyWithdraw() {
		final double withdrawAmoun = 150.15;
		
		savAccoun1.withdraw(withdrawAmoun);
		transactionList = savAccoun1.getTransactions();
		
		assertThat(transactionList.contains(null), is(false));
		assertEquals(transactionList.get(0).getType(), TransactionType.PENALTY);
	}
	
	/**
	 * Test method for {@link banking.Account#transfer(Account, Account, double)}.
	 */
	@Test
	public void testTransfer() {
		final double amount = 100.25;
		final double expectedAccoun1Balance = 200.40;
		final double expectedAccoun2Balance = 349.90;
		
		SavingsAccount.transfer(savAccoun2, savAccoun1, amount);
		
		assertEquals(savAccoun2.getBalance(), expectedAccoun2Balance);
		assertEquals(savAccoun1.getBalance(), expectedAccoun1Balance);
	}
	
	/*
	 * Test method for {@link banking.SavingsAccount#setDefaultInterestRate(double)}.
	 */
	@Test
	public void testSetDefaultInterestRate() {
		final double newInterestRate = 3.2;
		double result;
		SavingsAccount.setDefaultInterestRate(newInterestRate);
		result = SavingsAccount.getDefaultInterestRate();
		
		assertEquals(result, newInterestRate);
	}

}
