import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BankTest {

    private Bank bank;

    private BankStaff bankStaff1;
    private Client client1;
    private Client client2;
    private Client client3;
    private Client client4;


    @Before
    public void before(){

        bank = new Bank("Looyds");
        bankStaff1 = new BankStaff("Jane", "Cashier");
        client1 = new Client("Davide Venditti", 23, 1200);
        client2 = new Client("Albert", 17, 100);
        client3 = new Client("Bob", 15, 0);
        client4 = new Client("Bill", 55, 1000000);

        bankStaff1.openAccount(client1,bank);
        bankStaff1.openAccount(client2,bank);
        bankStaff1.openAccount(client4,bank);

        bankStaff1.depositMoneyInCustomerAccount(client1, 1000);
        bankStaff1.depositMoneyInCustomerAccount(client2, 50);
        bankStaff1.depositMoneyInCustomerAccount(client4, 500000);
    }

    @Test
    public void CanGetNumberOfActiveCustomer(){
        assertEquals(3, bank.getNumberOfClients());
    }

    @Test
    public void canAddEmployee(){
        bank.addEmployee(bankStaff1);
        assertEquals(1, bank.getNumberOfEmployee());
    }

    @Test
    public void canGetRegister(){
        bank.getRegister();
    }

    @Test
    public void canDoForecast(){
        assertEquals(266.66,bank.forecast(client1, 3), 0.01);
    }







}
