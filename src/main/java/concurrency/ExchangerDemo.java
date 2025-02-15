package concurrency;

import lombok.AllArgsConstructor;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(new ExchangerTask(exchanger, "Message from thread1"), "Thread1").start();
        new Thread(new ExchangerTask(exchanger, "Message from thread2"), "Thread2").start();
    }
}

@AllArgsConstructor
class ExchangerTask implements Runnable {
    private Exchanger<String> exchanger;
    private String message;


    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has message " + message);
            String receivedMsg = exchanger.exchange(message);
            System.out.println(Thread.currentThread().getName() + " receive message " + receivedMsg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}