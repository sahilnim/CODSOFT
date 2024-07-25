import java.util.Scanner;

class BankAccount 
{
    private double balance;
    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Deposit of ₹ "+amount+" successful. And Yours current balance is ₹ "+balance);    
        } 
        else
        {
            System.out.println("Invalid Amount");
        }
    }
    public void withdraw(double amount)
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;
            System.out.println("Withdrawal of ₹ "+amount+" successful. And Yours current balance is ₹ "+balance);
        } 
        else 
        {
            System.out.println("Invalid amount Or Insufficient Balance");            
        }
    }
}
class ATM
{
    private BankAccount bankaccount;

    public ATM(BankAccount bankaccount)
    {
        this.bankaccount=bankaccount;
    }
    public void displayMenu()
    {
        System.out.println("----- ATM MENU -----");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void performTransaction(int choice, Scanner sc)
    {
        switch (choice) {
            case 1:
                    System.out.println("Current Balance is ₹"+bankaccount.getBalance());
                    break;
            case 2:
                    System.out.println("Enter deposit amount :  ₹");
                    double depositAmount = sc.nextDouble();
                    bankaccount.deposit(depositAmount);
                    break;
            case 3:
                    System.out.println("Enter withdrawal amount :  ₹");
                    double withdrawalAmount = sc.nextDouble();
                    bankaccount.withdraw(withdrawalAmount);
                    break;
            case 4:
                    System.out.println("Thankyou !");
                    sc.close();
                    System.exit(0);
            default:
                    System.out.println("Invalid Choice");
        }
    }
}

public class task3 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter initial account balance : ₹");
        double initialBalance = sc.nextDouble();
        BankAccount bankaccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankaccount);

        while (true) 
        {
        atm.displayMenu();
        System.out.println("Select an option");
        int choice = sc.nextInt();
        atm.performTransaction(choice, sc);    
        }
    }
}
