import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

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
        customers.put(customerId2,customer2);
        assertTrue(customers.containsKey(customerId1));
        assertEquals(customer1,customers.get(customerId1));
        assertTrue(customers.containsKey(customerId2));
        assertEquals(customer2,customers.get(customerId2));
    }

    @Test
    void removeCustomer() {
        Bank bank = new Bank("Bank of America");
        String customerId1 = bank.addCustomer("Johnson","Dwayne");
        Customer customer1 = new Customer(bank,"Johnson","Dwayne");
        customers.clear();
        customers.put(customerId1,customer1);
        customers.remove(customerId1);
        bank.removeCustomer(customerId1);
        assertNull(bank.getCustomer(customerId1));
    }

    @Test
    void getAllCustomers() {
        customers.clear();
        Bank bank = new Bank("Bank of America");
        String customerId1 = bank.addCustomer("Cena","John");
        Customer customer1 = new Customer(bank,"Cena","John");
        customers.put(customerId1,customer1);
        SortedSet<Customer> testCustomers = bank.getAllCustomers();
        assertEquals(new TreeSet<Customer>().add(customer1),testCustomers);
    }

    @Test
    void getCustomer() {
        customers.clear();
        Bank bank = new Bank("Bank of America");
        String customerId1 = bank.addCustomer("Obama","Barrack");
        Customer customer1 = new Customer(bank,"Obama","Barrack");
        customers.put(customerId1,customer1);
        assertEquals(customers.get(customerId1),bank.getCustomer(customerId1));
    }

    @Test
    void getCustomer1() {
    }

    @Test
    void getCustomersAccounts() {
    }
}