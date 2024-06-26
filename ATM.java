import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double balance) 
    {
        this.balance = balance;
    }
    public double getBalance() 
    {
        return balance;
    }
    public void deposit(double amount) 
    {
        balance += amount;
    } 
    public boolean withdraw(double amount) 
    {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else 
        {
            return false;
        }
    }
}
public class ATM 
{
    private BankAccount bankAccount;    
    public ATM(BankAccount bankAccount) 
    {
        this.bankAccount = bankAccount;
    }
    public void withdraw(double amount) 
    {
        if (bankAccount.withdraw(amount)) 
        {
            System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getBalance());
        } else 
        {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }
    public void deposit(double amount) 
    {
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: " + bankAccount.getBalance());
    }
    public void checkBalance() 
    {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
    public static void main(String[] args) 
    {
        try (Scanner scanner = new Scanner(System.in)) 
        {
            BankAccount bankAccount = new BankAccount(10000);
            ATM atm = new ATM(bankAccount);
            while (true) 
            {
                System.out.println("\nWelcome to the ATM");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your option: ");
                int choice = scanner.nextInt();
                switch (choice) 
                {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        atm.checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}