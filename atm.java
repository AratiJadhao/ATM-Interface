public class atm {
              import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountNumber;
    private String pin;
    
    public ATM(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 0.0;
    }
    
    public void displayMenu() {
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
        System.out.println("Current Balance: $" + balance);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            System.out.println("Current Balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    
    public boolean validatePin(String enteredPin) {
        return pin.equals(enteredPin);
    }
    
    public static void main(String[] args) {
        ATM atm = new ATM("1234567890", "1234"); // Replace with your account number and PIN
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the ATM.");
        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();
        
        if (atm.validatePin(enteredPin)) {
            boolean exit = false;
            
            while (!exit) {
                atm.displayMenu();
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                
                System.out.println();
            }
        } else {
            System.out.println("Invalid PIN. Exiting...");
        }
    }
}

}
