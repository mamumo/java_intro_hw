import static org.junit.Assert.*;
import org.junit.*;

public class BankTest {
  Bank bank;
  CurrentAccount current;
  SavingsAccount savings;



  @Before
  public void before() {
    bank = new Bank("TSB");
    current = new CurrentAccount();
    savings = new SavingsAccount();
  } 

  @Test
  public void hasName() {
    assertEquals("TSB", bank.getName());
  }

  @Test
  public void noAccountsToBeginWith() {
    assertEquals(0, bank.numberOfAccounts());
  }

  @Test
  public void canAddAccountToBank() {
    bank.add(savings);
    assertEquals(1, bank.numberOfAccounts());
  }

  // @Test
  // public void tooMuchMoneyInBank() {
  //   for( int i = 0; i < 2; i++) {
  //     bank.add(account);
  //   }
  //   assertEquals(true, bank.bankIsFull());
  // }

  @Test
  public void shouldHaveNoAccountsWhenBroke() {
    bank.add(current);
    assertEquals(1, bank.numberOfAccounts());
    bank.broke();
    assertEquals(0, bank.numberOfAccounts());
  }

  @Test
  public void payInterest() {
  bank.add(current);
  assertEquals(5, current.interest());
  }

  @Test
  public void needsBailingOut() {
    bank.add(current);
    InterestPayable account = bank.goesBust();
    CurrentAccount original = (CurrentAccount) account;
    assertEquals("pay some bills", original.debit());
  }

  @Test
  public void totalInterest(){
    bank.add(current);
    bank.add(savings);
    assertEquals(15, bank.totalInterest());
  }
}