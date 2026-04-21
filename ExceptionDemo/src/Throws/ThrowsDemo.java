package Throws;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsDemo {
    public static void main(String[] args) {
        try {
            m1();
        }
        catch (FileNotFoundException e )
        {
            System.out.println("FileNotFoundException Checked Exception is Handled in caller method using throws keyword");
        }

    }
    public static void m1() throws FileNotFoundException {
        m2();
    }
    public static void m2() throws FileNotFoundException {
        m3("Rohit.txt");
    }
    public static void m3(String filename) throws FileNotFoundException {
        try {
            FileReader fis = new FileReader(filename);
        }
        finally {
            System.out.println("finally block");
        }
    }
}
