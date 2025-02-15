package concurrency;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        int numWorkers = 3;
        Phaser phaser = new Phaser(numWorkers);
        for (int i = 0; i < numWorkers; i++) {
            new Thread(new Worker(phaser), String.format("Worker-%d", i)).start();
        }
    }
}

class Worker implements Runnable {
    private Phaser phaser;

    Worker(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting phase 0");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + " start phase 1");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + " start phase 2");
        phaser.arriveAndAwaitAdvance();

        System.out.println(Thread.currentThread().getName() + " complete all phases");
    }
}
