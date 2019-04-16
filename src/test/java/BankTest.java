import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankTest {
    private SortedSet<Account> customerAccounts = new TreeSet<>();
    private final Map<String, Customer> customers = new HashMap<>();


    @Test
    void getInsufficientFundsPenalty() {
        Bank bank = new Bank("Bank of America");
        assertEquals(10.0,bank.getInsufficientFundsPenalty());
    }

    @Test
    void setInsufficientFundsPenalty() {
        Bank bank = new Bank("Bank of America");
        bank.setInsufficientFundsPenalty(20.0);
        assertEquals(20,bank.getInsufficientFundsPenalty());
    }

    @Test
    void getNAME() {
        Bank bank = new Bank("Bank of America");
        assertEquals("Bank of America",bank.getNAME());
    }

    @Test
    void getAllAccounts() {
        Customer customer1 = new Customer(new Bank("Bank of America"),"Skywalker","Luke");
        Customer customer2 = new Customer(new Bank("Wells Fargo"),"Wayne","Bruce");
        Account account1 = new Account(customer1,100,"Skywalker is cheap") {
            @Override
            public void deposit(double amount) {

            }

            @Override
            public void withdraw(double amount) {

            }
        };
        Account account2 = new Account(customer2,100000000,"He is rich") {
            @Override
            public void deposit(double amount) {

            }

            @Override
            public void withdraw(double amount) {

            }
        };
        customerAccounts.add(account1);
        customerAccounts.add(account2);
        assertTrue(customerAccounts.contains(account1));
        assertTrue(customerAccounts.contains(account2));
    }

    @Test
    void addCustomer() {
        Bank bank = new Bank("Bank of America");
        String customerId1 = bank.addCustomer("Moriarty","James");
        String customerId2 = bank.addCustomer("Holmes","Sherlock");
        Customer customer1 = new Customer(bank,"Moriarty","James");
        Customer customer2 = new Customer(bank,"Holmes","Sherlock");
        customers.put(customerId1,customer1);
        assertTrue(customers.containsKey(customerId1));
        assertEquals(customer1,customers.get(customerId1));
        assertTrue(customers.containsKey(customerId2));
        assertEquals(customer2,customers.get(customerId2));
    }

    @Test
    void removeCustomer() {
    }

    @Test
    void getAllCustomers() {
    }

    @Test
    void getCustomer() {
    }

    @Test
    void getCustomer1() {
    }

    @Test
    void getCustomersAccounts() {
    }
}