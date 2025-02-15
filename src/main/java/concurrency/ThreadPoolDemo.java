package concurrency;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3);

        for (int i = 0; i <= 10; i++) {
            int taskId = i;
            threadPool.execute(() -> {
                System.out.println("Task " + taskId + " is running");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + taskId + " completed");
            });

        }
    }
}
