package com.epam.academy.exercises.singlethreadscheduledexecutor;

import java.util.Date;

public class MyTask implements Runnable {

	private final int id;
	
	public MyTask(int id) {
		this.id = id;
	}

	@Override
	public void run() {
        System.out.printf("Task" + id + " is running in [" 
                + Thread.currentThread().getName() + "] at %tr%n", new Date());
	}

}
