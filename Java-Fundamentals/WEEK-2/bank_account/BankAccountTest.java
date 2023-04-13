public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount checkingAccount = new BankAccount();
        checkingAccount.depositToChecking(1000.0);
        System.out.println("Checking Account Balance is: " + checkingAccount.getCheckingBalance());

        System.out.println("========================================================");

        BankAccount savingsAccount = new BankAccount();
        savingsAccount.depositToSaving(5278.68);
        System.out.println("Savings Account Balance is: " + savingsAccount.getSavingBalance());

        System.out.println("========================================================");
        checkingAccount.withdrawFromChecking(500);
        System.out.println("Checking Balance after withdraw " + checkingAccount.getCheckingBalance());

        System.out.println("========================================================");
        savingsAccount.withdrawFromSaving(1325.21);
        System.out.println("Savings Balance after withdraw " + savingsAccount.getSavingBalance());



    }
}