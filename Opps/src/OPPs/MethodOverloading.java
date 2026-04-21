package OPPs;

public class MethodOverloading {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println( c.add(10,10));
        System.out.println(c.add(10.5,10.5));
        System.out.println(c.add("10", "10"));
    }
}
