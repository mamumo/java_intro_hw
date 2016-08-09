import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BankTest {
  Bank bank;
  Account account;


  @Before
  public void before() {
    bank = new Bank("TSB");
    account = new Account();
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
    bank.add(account);
    assertEquals(1, bank.numberOfAccounts());
  }

  @Test
  public void tooMuchMoneyInBank() {
    for( int i = 0; i < 2; i++) {
      bank.add(account);
    }
    assertEquals(true, bank.bankIsFull());
  }

  @Test
  public void shouldHaveNoAccountsWhenBroke() {
    bank.add(account);
    assertEquals(1, bank.numberOfAccounts());
    bank.broke();
    assertEquals(0, bank.numberOfAccounts());
  }
}