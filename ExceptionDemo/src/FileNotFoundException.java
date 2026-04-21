import java.io.FileReader;

public class FileNotFoundException { // fully checked exception
    public static void main(String[] args) throws java.io.FileNotFoundException {
        FileReader fileReader = new FileReader("Rohit.txt");//FileNotFoundException
    }
}
