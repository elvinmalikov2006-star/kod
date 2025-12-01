import java.util.Objects;
import java.util.Scanner;

public class Account {
           private String accountNumber;
           private String ownerName;
           private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public Account() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                "ownerName='" + ownerName + '\'' +
                '}';
    }
    public void setAccountNumber(String accountNumber) {
        if (accountNumber.isBlank() || accountNumber.trim().length() < 4){
            System.out.println("Invalid account number");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName.isBlank() || ownerName.length() < 3){
            System.out.println("Invalid owner number");
        }
        this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        if (balance < 0){
            System.out.println("Balance can not be negative");
            return;
        }
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double depositAmount){
        if (depositAmount < 0){
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + depositAmount;
    }
    public void withDrow(double withDrowAmount){
        if (withDrowAmount < 0) {
            System.out.println("Invalid withdrow amount");
            return;
        }
        if (balance < withDrowAmount){
            System.out.println("Insufitien balance");
            return;
        }
        balance = balance - withDrowAmount;
    }
}
