package mps;

public class TestAccount {
    
    public static void main(String[] args){
        
        Account cash = new Account(2016, 1000);
        System.out.println(cash);  // toString()
 
        // Test Setters and Getters
        cash.setBalance(1000);
        System.out.println(cash);  // run toString()
        System.out.println("Account no is: " + cash.getAccountNumber());
        System.out.println("Balance is: $" + cash.getBalance());

        cash.credit(1000);
        cash.debit(250);
        System.out.println(cash);  // toString()
    }
}