public class TryCatchFinally {
    public static void main(String[] args) {
        System.out.println("before exception");
        //int a = 10/0; stops further running of program due to exception
        try{
            //int a = 10/0;//airthmatic Exception--> runtime exception--> Exception(parent)
        }
        catch (Exception e){//e means object of exception using dynamic dispacher having child class object
            // exception parent class holds child class airthmatic exception's object using dynamic dispacher
            System.out.println(e);
            //System.out.println(e.getMessage());
            //e.printStackTrace();
        }//catch will always run if there is any exception in try
        finally{// always run even there is exception or not ,or exception handled or not
            System.out.println("finally block");
        }
        System.out.println("after exception");
    }
}
