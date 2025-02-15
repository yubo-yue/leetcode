package concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadPool {
    private final int threadCount;
    private final PoolWorker[] workers;
    private final Queue<Runnable> taskQueue;

    public ThreadPool(int threadCount) {
        this.threadCount = threadCount;
        this.taskQueue = new LinkedList<>();
        this.workers = new PoolWorker[this.threadCount];
        for (int i = 0; i < this.threadCount; i++) {
            workers[i] = new PoolWorker("Worker-" + i);
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (taskQueue) {
            taskQueue.add(task);
            taskQueue.notify();
        }
    }


    private class PoolWorker extends Thread {
        public PoolWorker(String name) {
            super(name);
        }

        @Override
        public void run() {
            Runnable task;
            while (true) {
                synchronized (taskQueue) {
                    while (taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    task = taskQueue.poll();
                }

                try {
                    System.out.println(Thread.currentThread().getName() + " executing tasks");
                    task.run();
                } catch (Exception e) {
                    System.out.println("executing task failure.");
                }

            }
        }
    }
}
