package com.baf.core;

public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("重写了run方法");
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread("测试线程类");
        for(int i=0;i<10;i++){
            System.out.print(mt.getName());
            mt.run();
        }
    }
}
