public class ChildParent {
    public static void main(String[] args) {
        System.out.println("before exception");
        try {
            String s = null;
            int l = s.length();
        }
        catch (ArithmeticException e) {// wrong handling of exception leads to exception
            System.out.println(e);
        }
        catch (NullPointerException e) { //child class of exception must be placed first
            System.out.println("NullPointerException");
        }
        catch (Exception e) {// if we didnot detetmined right exception then parent will definitely handles
            System.out.println("Exception");
        }
        System.out.println("after exception");
    }
}
