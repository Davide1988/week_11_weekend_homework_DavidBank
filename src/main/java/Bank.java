import java.util.ArrayList;
import java.util.HashMap;

public class Bank {

    private String name;
    private ArrayList<Client> clients;
    private ArrayList<BankStaff> staff;
    private HashMap<String, AccountType> register;

    public Bank(String name){
        this.name = name;
        this.clients = new ArrayList<>();
        this.staff = new ArrayList<>();
        this.register = new HashMap<>();
    }

    public int getNumberOfClients(){
        return this.clients.size();
    }

    public void getNewClient(Client client){
        this.clients.add(client);
    }

    public int getNumberOfEmployee(){
        return this.staff.size();
    }

    public void addEmployee(BankStaff staff){
        this.staff.add(staff);
    }

    public void  getRegister(){
        for(Client client : this.clients){
            this.register.put(client.getName(),client.showAccount());
        }
        System.out.println(this.register);
    }

    public double forecast(Client client, int months){
        double balance = client.getAccountBalance();
        AccountType type = client.showAccount();
        double intrestRate = type.getIntrestRate();
        double monltyIntrest = intrestRate / 12;
        double actualIntrest = balance * monltyIntrest;
        double actualIntrestRounded = Math.round(actualIntrest*100.0)/100.0;
        return actualIntrestRounded;
    }



}
