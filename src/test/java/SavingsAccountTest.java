import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {


    @Test
    void addInterestTransaction() {
        Bank bank = new Bank("Bank of America");
        Customer customer1 = new Customer(bank,"Batista","Dave");
        SavingsAccount savingsAccount1 = new SavingsAccount(customer1,10000,"Dave Batista is awesome");
        savingsAccount1.addInterestTransaction(20.0);
        List transactionList = savingsAccount1.getTransactions();
        assertNotNull(transactionList);
    }

    @Test
    void deposit() {
        Bank bank = new Bank("Sun Bank");
        Customer customer1 = new Customer(bank,"Lee","Bruce");
        SavingsAccount savingsAccount1 = new SavingsAccount(customer1,1000,"Bruce Lee is the dragon");
        savingsAccount1.deposit(20.0);
        assertEquals(1020.0,savingsAccount1.getBalance());
    }

    @Test
    void withdraw() {
        Bank bank = new Bank("Ameritrade");
        Customer customer1 = new Customer(bank,"Chan","Jackie");
        SavingsAccount savingsAccount1 = new SavingsAccount(customer1,100,"Jackie Chan is just testing us");
        savingsAccount1.withdraw(20.0);
        assertEquals(80.0,savingsAccount1.getBalance());
    }

    @Test
    void transferTest() {
        Bank bank = new Bank("Bank of America");
        Customer customer1 = new Customer(bank,"Bezos","Jeff");
        SavingsAccount savingsAccount1 = new SavingsAccount(customer1,123,"Amazon account");

        Customer customer2 = new Customer(bank,"Buffet","Warren");
        SavingsAccount savingsAccount2 = new SavingsAccount(customer2,100,"Berkshire acount");

        Account.transfer(savingsAccount1,savingsAccount2,23.0);
        assertEquals(100,savingsAccount1.getBalance());
        assertEquals(123, savingsAccount2.getBalance());

    }
}