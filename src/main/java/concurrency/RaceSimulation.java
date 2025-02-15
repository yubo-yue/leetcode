package concurrency;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RaceSimulation {
    private static final int NUM_OF_RACERS = 5;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUM_OF_RACERS, () -> System.out.println("all racers are Ready, GO"));

        for (int i = 0; i < NUM_OF_RACERS; i++) {
            new Thread(new Racer(barrier), "Racer" + i).start();
        }
    }
}

@RequiredArgsConstructor
class Racer implements Runnable {
    private final CyclicBarrier barrier;

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 3000));
            System.out.println(Thread.currentThread().getName() + " is ready to go");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " started");
        } catch (InterruptedException | BrokenBarrierException e) {
            Thread.currentThread().interrupt();
        }
    }
}
