package concurrency;

import java.util.concurrent.Semaphore;

public class ThreadSignalDemo {
    private final static Semaphore signal = new Semaphore(0);

    public static void main(String[] args) {
        Thread worker = new Thread(() ->{
            try {
                System.out.println("Worker is waiting for signal to start");
                signal.acquire();
                System.out.println("Work gets signal and start to work");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "worker");

        worker.start();
        try {
            Thread.sleep(1500);
            System.out.println("Main sending signal");
            signal.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
