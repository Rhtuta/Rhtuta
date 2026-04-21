package CallableAndFuture;

import java.util.concurrent.*;

public class CallableFutureExample {
    public static void main(String[] args) throws Exception {
        // Create a thread pool with one thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable task that calculates sum of numbers
        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum; // returns result
        };

        // Submit Callable task and get a Future
        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted! You can do other work now...");

        // Get the result (blocks if not ready)
        int result1 = future.get();
        boolean result2 = future.isDone();
        System.out.println("Result from Callable: " + result1);
        System.out.println("Result from Callable: " + result2);
        boolean result3 = future.cancel(true);//return false due to already upper stmt executed
        System.out.println("Result from Callable: " + result3);

        // Shutdown executor
        executor.shutdown();
    }
}

