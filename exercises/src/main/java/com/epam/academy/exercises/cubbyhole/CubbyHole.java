package com.epam.academy.exercises.cubbyhole;

public class CubbyHole {
	
	private int value;
	
	private volatile boolean available = false;

	public int get(String threadName) throws InterruptedException {
		synchronized (this) {
			while( available == false) {
				wait();
			}			
			available = false;
			System.out.println("The thread " + threadName + " got: " + value);
			notify();
			return value;
		}
	}

	public void put(int value, String threadName) throws InterruptedException {
		synchronized (this) {
			while( available == true) {
				wait();
			}
			this.available = true;
			this.value = value;		
			System.out.println("The thread " + threadName + " put: " + value);
			notify();
		}
	}
}
