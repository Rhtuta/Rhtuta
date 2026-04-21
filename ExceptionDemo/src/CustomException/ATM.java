package CustomException;

public class ATM {
    public static void main(String[] args) {
        try{
            withrawal(2000,1000);
        }
        catch (InsufficientBalException e){
            System.out.println("Exception occurs: " + e.getMessage());
        }

    }
    public static void withrawal(double amount, double bal) throws InsufficientBalException {
        if(amount>bal){
            throw new InsufficientBalException("Insufficient balance : amount available "+bal+ " requested amount "+ amount);
        }
        System.out.println("Withrawal successful");
    }
}

