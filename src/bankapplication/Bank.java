
package bankapplication;


public class Bank {
    
    private int numAccounts ;
    private int maxAccount;
    private Account[] accountList;
    
    public Bank(int maxAccount){
        this.maxAccount = maxAccount;
        this.numAccounts = 0;
        accountList = new Account[maxAccount];                
    }
    public boolean addAccount(long accNum,double bal,String own){
        if(numAccounts >= maxAccount){return false;}
        Account a = new Account(accNum,bal,own);
        accountList[numAccounts] = a;
        numAccounts++;
        return true;
    }
    
    public String printAccounts(){
        String s = "Account List: \n";
        for(int i = 0 ; i< numAccounts; i++){
            s += accountList[i].toString() +"\n";
        }
        return s;
    }
    public int findAccount(long accNum){
        for(int i = 0 ; i<numAccounts; i++){
            if(accountList[i].getAccountNum() == accNum){
                return i;
            }
        }
        return -1;
    }
    public void depositAccount(long accNum, double amount){
        int loc;
        loc = findAccount(accNum);
        if(loc == -1){
            System.out.println("Account doesn's exist..");
        }
        else{
            accountList[loc].deposit(amount);
        }
    }
    
    public boolean withdrawAccount(long accNum,double amount){
        int loc;
        loc = findAccount(accNum);
        if(loc == -1){
            return false;
        }
        else{
            accountList[loc].withdraw(amount);
            return true;
        }
    }
    
    public boolean transfer(long accountFrom, long accountTo,double amount){
        int loc1,loc2;
        loc1 = findAccount(accountFrom);
        loc2 = findAccount(accountTo);
        
        if(loc1 == -1|| loc2 ==-1){
            return false;
        }
        else{
            accountList[loc1].transfer(accountList[loc2], amount);
            return true;
        }
    }
    
}
