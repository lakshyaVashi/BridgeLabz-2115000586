import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccount {
    private double balance;

    public BankAccount() {
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount();
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(100.0);
        assertEquals(100.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdraw() {
        bankAccount.deposit(200.0);
        bankAccount.withdraw(150.0);
        assertEquals(50.0, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        bankAccount.deposit(100.0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(150.0));
    }

    @Test
    public void testMultipleTransactions() {
        bankAccount.deposit(500.0);
        bankAccount.withdraw(200.0);
        bankAccount.deposit(300.0);
        assertEquals(600.0, bankAccount.getBalance());
    }
}