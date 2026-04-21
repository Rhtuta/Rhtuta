import java.io.FileInputStream;
import java.io.IOException;

public class CheckedException {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        System.out.println("before exception");
        try{
             fis = new FileInputStream("Rohit.txt");
        }
        catch (IOException e){//fully checked exception
            System.out.println("FileNotFoundException ");
            //System.exit(0);//this will make JVM to stop further execution and finally will not run here
        }
        finally {
            fis.close();// this close method is checked Exception  so we have to add its signature in main method becausse these exception is checked at compile time
            System.out.println("finally block");
        }
    }
}
