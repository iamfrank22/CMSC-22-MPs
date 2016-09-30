package mps;

public class Account {
    private int accountNumber;
    private double balance = 0.0;
    
    public Account(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public Account(int accountNumber){
        
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void credit(double amount){
        if (balance >= amount)
            balance = balance - amount;
        else
            throw new IllegalArgumentException("Amount withdrawn exceeds the current balance!");
    }
    public void debit(double amount){
        balance = balance + amount;
    }
    public String toString(){
        String formattedAccount = String.format("A/C no: %d, Balance: $%.02f", this.accountNumber, this.balance);
        return formattedAccount;
    }
    
}
