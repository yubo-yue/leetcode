package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {
    private int data = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void readData() {
        rwLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " is reading data " + data);
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void writeData(int data) {
        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + " is writing data " + data);
            Thread.sleep(500);
            this.data = data;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        SharedData data = new SharedData();

        Runnable reader = () -> {
            while (true) {
                data.readData();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Runnable writer = () -> {
            int newData = 1;
            while (true) {
                data.writeData(newData);
                newData++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(reader, "Reader-" + i).start();
        }

        new Thread(writer, "writer").start();
    }

}
