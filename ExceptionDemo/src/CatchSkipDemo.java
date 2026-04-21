public class CatchSkipDemo {
    public static void main(String[] args) {

        try {
            System.out.println("simple code in try block");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("finally block and catch skipped due to not any exception");
        }
    }
}
