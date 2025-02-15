package concurrency;

import java.util.concurrent.Semaphore;

public class DatabaseConnectionPool {
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new DatabaseTask(semaphore), "Thread-" + i).start();
        }
    }
}

class DatabaseTask implements Runnable {
    private Semaphore permits;

    public DatabaseTask(Semaphore permits) {
        this.permits = permits;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " waiting for executing");
        try {
            permits.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired a permit");
            Thread.sleep((long) (Math.random() * 5000));
            System.out.println(Thread.currentThread().getName() + " release a permit");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            permits.release();
        }

    }
}
