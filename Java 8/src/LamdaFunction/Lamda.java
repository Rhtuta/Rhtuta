package LamdaFunction;

public class Lamda {
    public static void main(String[] args) {
        //implement thread using lamda func without creating any thread class
        Runnable task1 = ()-> System.out.println("Thread run method using Lamda function");
        new Thread(task1).start();
        //for multiline stmts execution
        Runnable task2 = ()-> {
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+ ":  Hello Thread");
            }
        };
        new Thread(task2).start();
        for (int i = 0; i <5 ; i++) {
            System.out.println(Thread.currentThread().getName()+ ":  Hello main");
        }
    }
}
