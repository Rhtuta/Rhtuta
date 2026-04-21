package Questions;

public class Q1 {
    public static void main(String[] args) {
        System.out.println("Hello");
        try {
            System.out.println("I am");
        }
        catch (Exception e){
            System.out.println("Exception");//No exception so catch will not run
        }
        System.out.println("Done");
    }
}
