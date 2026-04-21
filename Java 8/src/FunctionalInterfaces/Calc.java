package FunctionalInterfaces;

@FunctionalInterface
public interface Calc {
    public int add(int a,int b);
}

//before java 1.8
/*class math implements Calc{
    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        math m = new math();
        m.add(5,4);
    }
}*/


//after java 1.8
class calculate{
    public static void main(String[] args) {
        // in case of return type is int then print result outside lamda func not intside lamda func
        Calc calc = (a,b)-> a+b;
        System.out.println("Addition is: "+ calc.add(5,10));


        // in case of return type is void then print result in lamda func not outside lamda func
        /*Calc calc = (a,b)-> System.out.println(a+b) ;
        calc.add(5,10);*/
    }
}




