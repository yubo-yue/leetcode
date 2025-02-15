package concurrency;

public class ThreadLocalCounterExample {
    private static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = counter.get();
            for (int i = 0; i < 5; i++) {
                value++;
                counter.set(value);
                System.out.println(Thread.currentThread().getName() + " counter " + value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            counter.remove();
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}
