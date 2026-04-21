package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(8);
        String[] stdList = {
                "Rohit", "Mohit", "Sumit", "Amit", "Ankit",
                "Rajesh", "Suresh", "Ramesh", "Mahesh", "Lokesh",
                "Vineet", "Deepak", "Sunil", "Manish", "Arjun",
                "Karan", "Varun", "Vikas", "Rahul", "Sanjay"
        };
        for (String name:stdList){
            CertificateSender certificateSender = new CertificateSender(name);
            service.submit(certificateSender);
        }
        service.shutdown();

    }
}
/*
1. Executors.newCachedThreadPool()

👉 Concept:

It creates a thread pool that can dynamically grow and shrink based on demand.

If a task comes in and there is no idle thread, it creates a new one.

If a thread is idle for 60 seconds, it is removed from the pool.

👉 Characteristics:

Unbounded thread pool (theoretically unlimited number of threads, limited only by system resources).

Good for applications with many short-lived asynchronous tasks.

Threads are reused if available; otherwise, a new thread is created.

👉 Example:

ExecutorService executor = Executors.newCachedThreadPool();

for (int i = 0; i < 5; i++) {
    final int taskId = i;
    executor.execute(() -> {
        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
    });
}

executor.shutdown();


👉 Use case:

When tasks come irregularly and may be short-lived.

Example: handling network requests or lightweight background tasks.

2. Executors.newSingleThreadExecutor()

👉 Concept:

Creates a single-threaded executor with only one worker thread.

All submitted tasks are executed sequentially, one at a time, in the order they were submitted (FIFO order).

If the thread dies unexpectedly, it creates a new one to continue execution.

👉 Characteristics:

Guarantees sequential execution (no parallelism).

Ensures that only one task is active at a time.

Internally backed by a LinkedBlockingQueue to hold tasks.

👉 Example:

ExecutorService executor = Executors.newSingleThreadExecutor();

for (int i = 0; i < 5; i++) {
    final int taskId = i;
    executor.execute(() -> {
        System.out.println("Task " + taskId + " executed by " + Thread.currentThread().getName());
    });
}

executor.shutdown();


👉 Use case:

When you want tasks to be executed in order and only one at a time.

Example: writing logs to a file, updating shared data sequentially, or sending emails one by one.

🔑 Comparison in Thread Pool Management
Feature	newCachedThreadPool()	newSingleThreadExecutor()
Thread Count	Dynamic (0 → unlimited, as needed)	Exactly 1
Task Execution	Multiple tasks in parallel (if multiple threads created)	Tasks run one after another
Idle Thread Timeout	60 seconds (idle threads removed)	Not applicable (always 1 active thread)
Best For	Many short-lived, bursty, asynchronous tasks	Sequential tasks that must not overlap
Risk	Can create too many threads → risk of OutOfMemoryError if tasks are too many	Potential bottleneck since only 1 thread handles everything

✅ In summary:

newCachedThreadPool() → scalable, elastic pool, good for bursty workloads.

newSingleThreadExecutor() → sequential execution, good when you want strict order and no parallelism.
 */
