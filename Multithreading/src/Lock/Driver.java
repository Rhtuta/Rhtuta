package Lock;

public class Driver {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable task1 = ()->account.withraw("Papa", 500);
        Runnable task2 = ()->account.withraw("Mummy", 400);
        Runnable task3 = ()->account.withraw("bro", 700);
        Runnable task4 = ()->account.withraw("Myself", 500);
        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
        new Thread(task4).start();
    }
}
