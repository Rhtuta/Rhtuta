package Questions;

public class TryWithoutCatch {
    public static void main(String[] args) {
        try{//try cant run alone it must need a pair whether it is catch or finally block
            System.out.println("try block");
        }
        /*catch (Exception e ){//not run if there is not any exception
            System.out.println("Exception");
        }*/
        finally {// try can run without catch only
            System.out.println("finally block");
        }
    }
}
