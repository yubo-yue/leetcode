package concurrency;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Phaser;

public class DataProcessingExample {
    public static void main(String[] args) {
        List<String> dataChunks = Arrays.asList("Chunk1", "Chunk2", "Chunk3", "Chunk4");
        Phaser phaser = new Phaser(1);

        for (String chunk : dataChunks) {
            phaser.register();
            new Thread(new DataWorker(chunk, phaser)).start();
        }

        phaser.arriveAndAwaitAdvance();
        System.out.println("All data processed for phase 1");
        phaser.arriveAndDeregister();
    }
}

@RequiredArgsConstructor
class DataWorker implements Runnable {
    private final String dataChunk;
    private final Phaser phaser;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " process " + dataChunk);
            Thread.sleep(1000);
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            phaser.arriveAndDeregister();
        }
    }
}