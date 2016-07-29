package com.company.Threads;

/**
 * @author rmandada
 */
public class CreatingStartingThreads {

    static int i=0;

    public static class MyThread1 extends Thread {


        public MyThread1(String s) {
            super(s);
        }

        @Override
        public void run() {
            /*System.out.println("MyThread1 is running");
            //System.out.println(Thread.currentThread().getName());*/
            incrementIAndPrint();
        }
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            /*System.out.println("MyRunnable is running");
            System.out.println(Thread.currentThread().getName());*/
            incrementIAndPrint();
        }
    }

    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1("New Thread");
        myThread1.start();
        System.out.println(myThread1.getName());

        Thread thread2 = new Thread(new MyRunnable(), "MyThread2");
        thread2.start();

        System.out.println(Thread.currentThread().getName());
        for(int i=0; i<10; i++){
            new Thread("" + i){
                public void run(){
                    System.out.println("Thread: " + getName() + " running");
                }
            }.start();
        }

    }

    public static synchronized void incrementIAndPrint() {
        System.out.println(++i);
    }
}
