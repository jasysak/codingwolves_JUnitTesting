import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getCustomerAccounts() {
        Bank bank = new Bank("Citigroup");
        Customer customer1 = new Customer(bank, "Kidman","Nicole");
        assertNotNull(customer1.getCustomerAccounts());
    }

    @Test
    void ytdFees() {
        Bank bank = new Bank("Wells Fargo");
        Customer customer1 = new Customer(bank,"Cruise","Tom");
        assertEquals(0.0,customer1.ytdFees());
    }

    @Test
    void ytdInterest() {
        Bank bank = new Bank("Chase");
        Customer customer1 = new Customer(bank, "Jolie","Angelica");
        assertEquals(0.0, customer1.ytdInterest());
    }

    @Test
    void addSavingsAccount() {
        Bank bank = new Bank("Bank of America");
        Customer customer1 = new Customer(bank, "Depp","Johnny");
        SavingsAccount savingAccounts1 = customer1.addSavingsAccount(300000,
                "Johnny Depp's savings account");
        assertEquals(300000, savingAccounts1.getBalance());
    }

    @Test
    void removeAccount() {
        Bank bank = new Bank("CitiBank");
        Customer customer1 = new Customer(bank, "Dogg","Snoop");
        Account account1 = new Account(customer1,100,"Snoop Dogg Account") {
            @Override
            public void deposit(double amount) {

            }

            @Override
            public void withdraw(double amount) {

            }
        };
        customer1.removeAccount(account1.getAccountId());
        assertNull(customer1.getCustomerAccounts());
    }

    @Test
    void getAccount() {

    }
}