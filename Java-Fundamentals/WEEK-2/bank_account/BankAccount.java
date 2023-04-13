public class BankAccount {
    private double checkingBalance;
    private double savingBalance;
    private static int accounts = 0;
    private static double balance = 0.0;

    public BankAccount() {
        accounts++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public double getSavingBalance() {
        return savingBalance;
    }

    public void depositToChecking(double amount) {
        checkingBalance += amount;
        balance += amount;
    }
    public void depositToSaving(double amount) {
        savingBalance += amount;
        balance += amount;
    }

    public void withdrawFromChecking(double amount) {
        if (checkingBalance >= amount) {
            checkingBalance -= amount;
            balance -= amount;
        } else {
            System.out.println("Insufficient funds available!");
        }
    }
    public void withdrawFromSaving(double amount) {
        if (savingBalance >= amount) {
            savingBalance -= amount;
            balance -= amount;
        } else {
            System.out.println("Insufficient funds available!");
        }
    }
}