package com.company.Threads;

/**
 * @author rmandada
 */
public class PrintEvenOdd {

    public static void main(String[] args) {
        Item item  = new Item(0);
        Thread oddCounter = new Thread(new OddCounter(item));
        Thread evenCounter = new Thread(new EvenCounter(item));

        oddCounter.start();
        evenCounter.start();
    }

    static class Item {
        int counter ;

        public Item(int counter) {
            this.counter = counter;
        }
    }

    public static class OddCounter implements Runnable {

        Item item;

        public OddCounter(Item item) {
            this.item = item;
        }

        @Override
        public void run() {
            try {
                while (item.counter <= 98) {
                    increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void increment() throws InterruptedException {
            synchronized (item) {
                while (item.counter % 2 == 1) {
                    item.wait();
                }
                item.counter++;
                System.out.println("From Odd Counter: "+item.counter);
                item.notify();
            }
        }
    }

    public static class EvenCounter implements Runnable {

        Item item;

        public EvenCounter(Item item) {
            this.item = item;
        }

        @Override
        public void run() {
            try {
                while (item.counter <= 99) {
                    increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void increment() throws InterruptedException {
            synchronized (item) {
                while (item.counter % 2 == 0) {
                    item.wait();
                }
                item.counter++;
                System.out.println("From Even Counter: "+item.counter);
                item.notify();
            }
        }
    }
}
