package Questions;

public class Q3 {
    public static void main(String[] args) {
        try {
            int[] arr = {10,20};
            System.out.println(arr[2]);//Exception
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException");// not valid exception so this will not catch exception
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");// child class object will catch exceptiono
        }
        catch (Exception e ){
            System.out.println("Exception");//parent class will not catch because already catch in child class
        }
        System.out.println("Exception caught");
    }
}
