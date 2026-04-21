package Questions;
public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            try {
                int a = 10/0;
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Array Index Inner catch");
            }
            catch (ArithmeticException e){//will catch Exception if its valid ExceptionS
                System.out.println("Airthmatic Inner Catch");
            }
            catch (Exception e){//Will catch Exception if above catch functions will not catch
                System.out.println("Exception inner catch");
            }
        }
        catch (Exception e ){// outer catch will catch valid Exception if Inner catch is not valid
            System.out.println("Outer Exception");
        }
    }
}
