package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
/*        //Basic Thread methods
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread().getName());

        //Priority: 1 lowest and 10 the highest
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().isAlive());

        //Pause a thread
        for(int i=3; i>0; i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Your are done!");*/

        //Change thread properties before start()
        MyThread thread2 = new MyThread();

        thread2.setDaemon(true);
        System.out.println(thread2.isDaemon());

        thread2.setName("2nd Thread");
        System.out.println(thread2.getName());

        thread2.setPriority(1);
        System.out.println(thread2.getPriority());

        thread2.start(); //.start() != .run()
        System.out.println(thread2.isAlive());
    }
}
