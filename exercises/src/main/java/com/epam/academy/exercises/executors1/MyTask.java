package com.epam.academy.exercises.executors1;

public class MyTask implements Runnable {

	private final int id;
	
	public MyTask(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task" + id + " is running in thread: " + Thread.currentThread().getName());
	}

}
