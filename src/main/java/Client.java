import java.util.ArrayList;

public class Client {


    private String fullName;
    private int age;
    private double funds;
    private ArrayList<Account> accounts;


    public Client(String fullName, int age, double funds){
        this.fullName = fullName;
        this.age = age;
        this.funds = funds;
        this.accounts = new ArrayList<>();
    }


    public String getName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    public double getFunds() {
        return this.funds;
    }

    public void getAccount(Account account){
       this.accounts.add(account);
    }

    public int getNumberOfAccounts(){
        return this.accounts.size();
    }

    public void deposit(double depos) {
        this.funds -= depos;
    }

    public void take(double take){
        this.funds += take;
    }

    public double depositIntoAccount(double deposit){
        Account account = this.accounts.get(0);
        double balance =  account.getBalance();
        double newBalance = balance += deposit;
        return newBalance;
    }

    public AccountType showAccount(){
        Account account = this.accounts.get(0);
        return account.getType();
    }

    public double getAccountBalance(){
        Account account = this.accounts.get(0);
        return account.getBalance();
    }


    public void addToBalance(double amount){
        Account account = this.accounts.get(0);
        account.add(amount);
    }

    public void takeToBalance(double amount){
        Account account = this.accounts.get(0);
        account.subtruct(amount);
    }


//    public void withdrawMoney(double amount) {
//        Account account = this.accounts.get(0);
//        double accountBalance = account.getBalance();
//        double newBalance = accountBalance -= amount;
//        accountBalance = newBalance;
//    }
}
