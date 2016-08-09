public class Bank {
  private String name;
  private Account [] accounts;



public Bank(String name){
  this.name = name;
  this.accounts = new Account[2];
}

public String getName(){
  return this.name;
}

public int numberOfAccounts() {
  int count = 0;
  for (Account account : accounts ) {
   if (account != null) {
    count++;
   }
 }
   return count;
}

public void add(Account account) {
  int numberOfAccounts = numberOfAccounts();
  accounts[numberOfAccounts] = account;
}

public boolean bankIsFull() {
  return numberOfAccounts() == accounts.length;
}

public void broke() {
  for(int i = 0; i < accounts.length; i++) {
    accounts[i] = null;
  }
}

}






