package com.epam.academy.exercises.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        ExecutorService executor = Executors.newCachedThreadPool();
        
        executor.execute(new Consumer(queue));
        executor.execute(new Producer(queue, 1, 6, 500));
        executor.execute(new Producer(queue, 2, 3, 300));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Sleep was interrupted: " + ex.getMessage());
        }
        executor.shutdown();
    }

}
