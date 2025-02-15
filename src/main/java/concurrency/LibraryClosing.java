package concurrency;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CountDownLatch;

public class LibraryClosing {

    public static void main(String[] args) {
        int numVisitors = 5;
        CountDownLatch latch = new CountDownLatch(5);
        for (int i = 0; i < numVisitors; i++) {
            new Thread(new Visitor(latch, String.format("Visitor-%d", i))).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All visitor go, closing library now");
    }
}

@RequiredArgsConstructor
class Visitor implements Runnable {
    private final CountDownLatch latch;
    private final String name;

    @Override
    public void run() {
        System.out.println(name + " is reading");

        try {
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(name + " has left the library");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}
