package com.baf.core.thread;

public class MyRunnable implements Runnable{

    public void run() {
        System.out.println("这里");
    }


    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
    }


}
