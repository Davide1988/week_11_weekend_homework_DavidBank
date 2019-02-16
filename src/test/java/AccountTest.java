import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {



    private Account account;


    @Before
    public void before(){
        account = new Account(AccountType.BUSINESS, 200);
    }

    @Test
    public void canGetType(){
        assertEquals(AccountType.BUSINESS, account.getType());
    }

    @Test
    public void canGetBalance(){
        assertEquals(200, account.getBalance(), 0.01);
    }

    @Test
    public void canGetInterestRateForType(){
        assertEquals(5.1, account.getRate(),0.1);
    }

    @Test
    public void canWithdrawMoney(){
        account.withdrawMoney(100);
        assertEquals(100, account.getBalance(),0.01);
    }
}
