package Questions;

public class PrintReturnTryCatchFinally {
    public static void main(String[] args) {
        System.out.println("Hello: "+ m1());
    }
    public static int m1()
    {
        try {
            //return 10/0;//will not return because its a Exception so gives error of missig return statement
            return 10; //will not execute & show error because upper state is exception so directly go to catch
        }
        //return 0; not possible & show error because try needed catch or finally to run
        /*catch (ArithmeticException e)//catch must not be there if try is returning with no exception
        //because if it is returning then next statement will not execute even if there is exception
        {
            System.out.println("ArithmeticException");
        }*/
       // return 0;//first catch will execute if there is Exception then return 0
        finally {
            System.out.println("finaly block");
        }
    }
}
