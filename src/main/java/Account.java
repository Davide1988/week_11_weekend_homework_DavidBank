public class Account {

    private String clientName;
    private AccountType type;
    private double balance;


    public Account(AccountType type, double balance){
        this.clientName  = clientName;
        this.type = type;
        this.balance = balance;
    }

    public AccountType getType() {
        return this.type;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getRate() {
        return this.type.getIntrestRate();
    }

    public double withdrawMoney(double money){
        return this.balance -= money;
    }

    public void add(double amount){
        this.balance += amount;
    }

    public void subtruct(double amount){
        this.balance -= amount;
    }

}
