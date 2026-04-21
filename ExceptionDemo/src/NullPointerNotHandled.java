public class NullPointerNotHandled {
    public static void main(String[] args) {
        System.out.println("before exception");
        try {
            String s = null;
            int l = s.length();
        }
        catch (ArithmeticException e) {// wrong handling of exception leads to exception
            System.out.println(e);
        }
        System.out.println("after exception");
    }
}
