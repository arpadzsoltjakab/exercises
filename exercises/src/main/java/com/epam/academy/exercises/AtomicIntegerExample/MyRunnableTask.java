package com.epam.academy.exercises.AtomicIntegerExample;

import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnableTask implements Runnable {

	private int id;
	
	private static int counter = 0;
	
	private static AtomicInteger atomicCounter = new AtomicInteger(0);
	
	public MyRunnableTask(int id) {
		this.id = id;
	}

	@Override
    public void run() {
        System.out.println("Task" + id + " [" + Thread.currentThread().getName()
                + "] AtomicInteger = " + atomicCounter.incrementAndGet()
                + " int = " + ++counter);
    }

}
