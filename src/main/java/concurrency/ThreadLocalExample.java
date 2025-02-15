package concurrency;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadId = new ThreadLocal<>() {
        private int id = 1;

        @Override
        protected Integer initialValue() {
            synchronized (this) {
                return id++;
            }

        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(), "Thread-" + i).start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            Integer id = threadId.get();
            System.out.println(Thread.currentThread().getName() + " has ID: " + id);
        }
    }
}
