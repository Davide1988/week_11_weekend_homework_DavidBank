import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ClientTest {


    private Client client;
    private Account account;

    @Before
    public void before(){

        client = new Client("Davide Venditti", 23, 1200);
        account = new Account(AccountType.PRIVATE, 2000);
    }

    @Test
    public void canGetName(){
        assertEquals("Davide Venditti", client.getName());
    }

    @Test
    public void canGetAge(){
        assertEquals(23, client.getAge());
    }

    @Test
    public void canGetFunds(){
        assertEquals(1200, client.getFunds(),0.01);
    }

//    @Test
//    public void canDepositMoney(){
//        client.deposit(1000);
//        assertEquals(200, client.getFunds(), 0.01);
//    }

    @Test
    public void canShowAccount(){
        client.getAccount(account);
        assertEquals(AccountType.PRIVATE, client.showAccount());
    }

    @Test
    public void canGetAccountBalance(){
        client.getAccount(account);
        assertEquals(2000, client.getAccountBalance(), 0.01);
    }

//    @Test
//    public void canGetMoneyFromHisAccount(){
//        client.getAccount(account);
//        client.withdrawMoney(200);
//        assertEquals(1800, client.getAccountBalance(account),0.01);
//    }






}
