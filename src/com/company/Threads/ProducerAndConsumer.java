package com.company.Threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rmandada
 */
public class ProducerAndConsumer {

    static Queue<Integer> sharedQueue = new LinkedList<>();
    static int size = 2;

    static class Producer implements Runnable {

        private Queue<Integer> sharedQueue;
        private int size;

        public Producer(Queue<Integer> queue, int size) {
            sharedQueue = queue;
            this.size = size;
        }

        @Override
        public void run() {
            for (int i = 0; i <7 ; i++) {
                produce(i);
            }
        }

        /*public void produce(int i) {
            if (sharedQueue.size()==size) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                sharedQueue.add(i);
                System.out.println("Produced: " + i );
            }
        }*/
    }

    static  public void produce(int i) {
        synchronized (sharedQueue) {
            if (sharedQueue.size()==size) {
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            sharedQueue.add(i);
            sharedQueue.notify();
            System.out.println("Produced: " + i );
        }


    }

    static class Consumer implements Runnable {

        private Queue<Integer> sharedQueue;
        private int size;

        public Consumer(Queue<Integer> queue, int size) {
            sharedQueue = queue;
            this.size = size;
        }

        /*public void consume() {
            if (sharedQueue.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                int x = sharedQueue.remove();
                System.out.println("Consumed: " + x );
            }
        }*/

        @Override
        public void run() {
            for (int i = 0; i <10 ; i++) {
                consume();
            }
        }
    }

    public static void consume() {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) {
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int x = sharedQueue.remove();
            sharedQueue.notify();
            System.out.println("Consumed: " + x);
        }
    }

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(sharedQueue, 2));
        Thread consumerThread = new Thread(new Consumer(sharedQueue, 2));

        producerThread.start();
        consumerThread.start();

        for (int i = 0; i <100 ; i++) {
            sharedQueue.add(10 + i);
        }
    }
}
