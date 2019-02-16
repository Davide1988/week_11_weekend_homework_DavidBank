public class BankStaff {

    private String name;
    private String title;

    public BankStaff(String name, String title){
        this.name = name;
        this.title = title;
    }

    public AccountType GetClientAccount(Client client){
        return client.showAccount();
    }

    public double GetClientBalance(Client client){
       return client.getAccountBalance();

    }


    public void openAccount(Client client, Bank bank) {
        if (client.getFunds() == 0 || client.getAge() < 15) {
            return;
        }
        if (client.getAge() < 18) {
            Account account = new Account(AccountType.YOUNG, 0);
            bank.getNewClient(client);
            client.getAccount(account);
        } else if (client.getAge() > 18 && client.getFunds() > 5000) {
            Account account = new Account(AccountType.BUSINESS, 0);
            bank.getNewClient(client);
            client.getAccount(account);
        } else {
            Account account = new Account(AccountType.PRIVATE, 0);
            bank.getNewClient(client);
            client.getAccount(account);
        }
    }

    public void depositMoneyInCustomerAccount(Client client, double amount) {
        client.addToBalance(amount);
        client.deposit(amount);
    }

    public void getMoneyFromCustomerAccount(Client client, double amount) {
        client.takeToBalance(amount);
        client.take(amount);
    }
}
