package concurrency;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CountDownLatch;

public class ApplicationStartup {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        new Thread(new Service("A", 1000, latch)).start();
        new Thread(new Service("B", 1000, latch)).start();
        new Thread(new Service("C", 1000, latch)).start();

        System.out.println("wait for service then start");
        latch.await();
        System.out.println("All service ready, app start");
    }
}

@RequiredArgsConstructor
class Service implements Runnable {
    @Getter
    private final String name;
    private final int startupTime;
    private final CountDownLatch latch;

    @Override
    public void run() {
        System.out.println(name + " is starting...");
        try {
            Thread.sleep(startupTime);
            System.out.println(name + " is up");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }

    }
}