package com.baf.core;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable {

    public Object call() throws Exception {
        String output = "This is my MyCallable Test";
        return output;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<MyCallable> futureTask = new FutureTask<MyCallable>(mc);
        Thread th = new Thread(futureTask);
        th.start();
        System.out.println(futureTask.get());
        System.out.println(futureTask.get());
    }
}
