package Throw;

public class ThrowDemo {
    public static void main(String[] args) {//if main also throws then object is created already by throw and now handled by Default Exception Handler
        try {
            Withrawal(1000, 500);
        }
        catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

    }
    public static void Withrawal(double amount, double bal) throws Exception {
        if(amount>bal){
            throw new Exception("Insufficient Balance");//checked exception made by us can be handled here or throws in caller method
            /*
            try
            {
                throw new Exception("Insufficient Balance");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }*/
        }
        System.out.println("Withrawal Successful");
    }
}
