public class MortgageAccount extends Account{
    public MortgageAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }
    public void  addMonthlyFee(){
        var newBalance = getBalance() - 10;
        if (newBalance < 0) {
            System.out.println("Balance is going to negative");
        }
        setBalance(getBalance() - 10);
    }
}
