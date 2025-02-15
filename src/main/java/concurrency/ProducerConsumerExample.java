package concurrency;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        //producer
        Runnable producer = () -> {
            int value = 0;
            try {
                while (true) {
                    queue.enqueue(value);
                    System.out.println("produced " + value);
                    System.out.println("queue size is :" + queue.size());
                    value++;
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    int v = queue.dequeue();
                    System.out.println("consume: " + v);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
//        new Thread(consumer).start();
    }
}
