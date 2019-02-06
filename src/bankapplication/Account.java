
package bankapplication;


public class Account {
    
    // some state
    private long accountNum;
    private double balance;
    private String owner;
    
    // constructor
    public Account(long accountNum,double balance,String owner){
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
    }
    
    // withdraw if there is sufficient funds
    public boolean withdraw(double amount){
        if(balance <= 0 || amount > balance){return false;}
        balance -= amount;
        return true;
    }
    
    // deposit
    public void deposit(double amount){
        balance += amount;
    }
    
    // transfer money from one account to another
    public boolean transfer(Account receivingAccount,double amount){
        if(balance <= 0 || amount > balance){return false;}
        receivingAccount.balance = receivingAccount.balance + amount;
        balance -= amount;
        return true; 
        
    }
    
    public long getAccountNum(){
        return accountNum;
    }
    public double getBalance(){
        return balance;
    }
    public String getOwner(){
        return owner;
    }
    
    public String toString(){
        String s = "";
        s += "- Account Number: " + accountNum + " , " + "Balance: " + balance + " , " + " Owner: " + owner;
        return s;
       
    }
    
}
