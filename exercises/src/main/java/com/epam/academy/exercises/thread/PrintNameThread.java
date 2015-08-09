package com.epam.academy.exercises.thread;

public class PrintNameThread extends Thread {
	
	public PrintNameThread(String name){
		super(name);
	}
	
	@Override
	public void run() {

		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep((long)(Math.random()*300));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Hello, my name is: " + this.getName() + " for the " + i + " time.");
		}

	}

}
