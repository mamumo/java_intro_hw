import java.util.*;

public class Bank {
  private String name;
  private ArrayList<InterestPayable> accounts;



public Bank(String name){
  this.name = name;
  this.accounts = new ArrayList<InterestPayable>();
}

public String getName(){
  return this.name;
}

public int numberOfAccounts() {
  return accounts.size();
}

public void add(InterestPayable account) {
 accounts.add(account);
}

// public boolean bankIsFull() {
//   return numberOfAccounts() == accounts.length;
// }

public void broke() {
 accounts.clear();
}

public InterestPayable goesBust() {
  if(numberOfAccounts() > 0) {
    return accounts.remove(0);
  }
  return null;
}

public int totalInterest() {
  int total = 0;
  for(InterestPayable account : accounts) {
    total += account.interest();
  }
  return total;
}

}






