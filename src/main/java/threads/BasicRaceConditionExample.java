package threads;

/**
 * There is two way to create thread.
 * One of them creating a class and extending it from Thread
 * Other is creating a class and implements it from Runnable
 * then, adding its object into to new Thread(x)
 * Correct way is using Runnable according to OOP principles.
 * Because, we only extends one class in Java but we can implements more than one interface to a class.
 * if we want to make sure about working order, we should use synchronized!
 * synchronized is making program thread-safe when we want to use shared object.
 */

public class BasicRaceConditionExample {

    public static void main(String args[]) {
        Data obj = new Data();
        obj.count= 100;

        Producer producer = new Producer(obj);
        Consumer consumer = new Consumer(obj);
        Thread consumerThread = new Thread(consumer);

        producer.start();
        consumerThread.start();
    }
}

/**
 * one of the creating thread method
 * all object that derived from this class will be a thread
 */
class Producer extends Thread {
    Data data; // only null ptr not object
    public Producer(Data data) {
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (data) {
                data.count++;
                System.out.println("# Producer : " + data.count);
            }
        }
    }
}

/**
 * Run function should be override when we implement Runnable
 * It is not thread. Because of that we add its object in Thread
 * into static void main.
 */
class Consumer implements Runnable {
    Data data;
    public Consumer(Data data) {
        this.data = data;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (data) {
                data.count--;
                System.out.println("Consumer : " + data.count);
            }
        }
    }
}

// shared object
class Data {
    int count;
}