package com.company;

public class MyThread extends Thread{

    @Override
    public void run(){
        if(this.isDaemon()){
            System.out.println("This is a Deamon thread is running!");
        }
        else{
            System.out.println("This is a user thread is running!");
        }
    }
}
