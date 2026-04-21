package OPPs;

public class ATM_Test {
    public static void main(String[] args) {
        ATM atm = new ATM("Ravi", 30000);
        //atm.accountHolderName = "Pankaj";//can change name and bal of person
        //atm.balance = 0;//outside the class, if instance is not private
        atm.showDetails();//in its class,which is risky (hacker);


        //here name and balance is hidden but showdetails method is necessary
        //to shown known as abstraction

    }
}
