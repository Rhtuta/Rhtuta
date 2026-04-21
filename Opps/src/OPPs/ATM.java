package OPPs;

public class ATM {
    private String accountHolderName;
    private double balance;
    ATM(String name, double balance){
        this.accountHolderName = name;
        this.balance = balance;
    }

    public static void main(String[] args) {
        ATM atm = new ATM("Rohit", 20000);
        atm.showDetails();
    }

    void showDetails(){
        System.out.println("Name: "+accountHolderName);
        System.out.println("balance: "+balance);
    }
}
