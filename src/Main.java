//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon
import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[5];
        while (true){
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. WithDrow");
            System.out.println("4. Run special action");
            System.out.println("5. Show account info");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter account number");
                String accountNo = scanner.nextLine();

                System.out.println("Enter owner name");
                String ownerName = scanner.nextLine();

                System.out.println("Enter starting balance");
                double startingBalance = scanner.nextDouble();

                System.out.println("Enter account type: 1(Loan)/ 2(Deposit)/ 3(Mortgage)");
                int accountType = scanner.nextInt();

                Account account = null;

                if (accountType == 1){
                    account = new LoanAccount(accountNo, ownerName, startingBalance);
                } else if (accountType == 2) {
                        account = new DepositAccount(accountNo, ownerName, startingBalance);
                } else if (accountType == 3) {
                    account = new MortgageAccount(accountNo, ownerName, startingBalance);
                } else System.out.println("Invalid choice");

                System.out.println(account instanceof LoanAccount);
                System.out.println(account instanceof MortgageAccount);

                for (int i = 0; i < accounts.length; i++){
                    if (accounts[i] == null){
                        accounts[i] = account;
                        System.out.println(Arrays.toString(accounts));
                        break;
                    }
                }
            }
                if (choice == 2){
                    System.out.println("Enter account number");
                    String accountNo = scanner.nextLine();

                    System.out.println("Enter amount");
                    String depositAmount = scanner.nextLine();
                }
            if (choice == 0) break;
        }
    }
}
