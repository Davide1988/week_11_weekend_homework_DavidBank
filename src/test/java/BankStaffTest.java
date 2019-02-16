import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankStaffTest {

    private Bank bank;
    private BankStaff bankStaff1;
    private Client client1;
    private Client client2;
    private Client client3;
    private Client client4;

    @Before
    public void before() {

        bank = new Bank("Looyds");
        bankStaff1 = new BankStaff("Jane", "Cashier");
        client1 = new Client("Davide Venditti", 23, 1200);
        client2 = new Client("Albert", 17, 100);
        client3 = new Client("Bob", 15, 0);
        client4 = new Client("Bill", 55, 1000000);
    }

    @Test
    public void canClientOpenAccount() {
        bankStaff1.openAccount(client1, bank);
        assertEquals(1, bank.getNumberOfClients());
        assertEquals(1, client1.getNumberOfAccounts());
    }

    @Test
    public void should_only_open_account_for_client_with_funds() {
        bankStaff1.openAccount(client1, bank);
        bankStaff1.openAccount(client3, bank);
        assertEquals(1, bank.getNumberOfClients());
        assertEquals(1, client1.getNumberOfAccounts());
        assertEquals(0, client3.getNumberOfAccounts());
    }

    @Test
    public void youngClientShouldOnlyBeAllowYoungAccountType(){
        bankStaff1.openAccount(client1, bank);
        bankStaff1.openAccount(client2, bank);
        assertEquals(2, bank.getNumberOfClients());
        assertEquals(1, client1.getNumberOfAccounts());
        assertEquals(1, client2.getNumberOfAccounts());
        assertEquals(AccountType.PRIVATE, client1.showAccount());
        assertEquals(AccountType.YOUNG, client2.showAccount());
    }
    @Test
    public void richClientShouldOnlyGetBusinessAccountType(){
        bankStaff1.openAccount(client1, bank);
        bankStaff1.openAccount(client2, bank);
        bankStaff1.openAccount(client4, bank);
        assertEquals(3, bank.getNumberOfClients());
        assertEquals(1, client1.getNumberOfAccounts());
        assertEquals(1, client2.getNumberOfAccounts());
        assertEquals(1, client4.getNumberOfAccounts());
        assertEquals(AccountType.PRIVATE, client1.showAccount());
        assertEquals(AccountType.YOUNG, client2.showAccount());
        assertEquals(AccountType.BUSINESS, client4.showAccount());
    }


    @Test
    public void customerCanDepositMoneyIntoHisAccount(){
        bankStaff1.openAccount(client1, bank);
        bankStaff1.depositMoneyInCustomerAccount(client1, 300);
        assertEquals(300, bankStaff1.GetClientBalance(client1), 0.01);
        assertEquals(900, client1.getFunds(),0.01);
    }

    @Test
    public void customerCanWidrawMoneyFromHisAccount(){
        bankStaff1.openAccount(client1, bank);
        bankStaff1.depositMoneyInCustomerAccount(client1, 300);
        bankStaff1.getMoneyFromCustomerAccount(client1, 100);
        assertEquals(200, bankStaff1.GetClientBalance(client1), 0.01);
        assertEquals(1000, client1.getFunds(),0.01);
    }



}
