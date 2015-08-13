package com.epam.academy.exercises.semaphoreexample1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ConnectionPoolManagedBySemaphore pool = new ConnectionPoolManagedBySemaphore(2);
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
        
		ResourceUserTask r1 = new ResourceUserTask(pool, 5, 400, 500);
        ResourceUserTask r2 = new ResourceUserTask(pool, 5, 800, 500);
        ResourceUserTask r3 = new ResourceUserTask(pool, 5, 1200, 500);

        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        executor.shutdown();
	}

}
