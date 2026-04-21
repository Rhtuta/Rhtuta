package Questions;

public class Q2 {
    public static void main(String[] args) {
        System.out.println("Hello");
        try {
            int a = 20/0;
            System.out.println("statement after exception");//will not run ,control will go to catch directly after Exception
        }
        catch (ArithmeticException e){
            System.out.println("Airthmatic Exception");
            //System.out.println(e);
        }
        System.out.println("Done");
    }
}
