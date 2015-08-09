package com.epam.academy.exercises.threadgroup;

public class PrintNameThread extends Thread {
	
	public PrintNameThread(String name){
		super(name);
	}
	
	@Override
	public void run() {

		for(int i = 0; i < 5; i++) {
			
			try {
				Thread.sleep((long)(Math.random()*1000)+100);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("Hello, my name is: " + this.getName() 
					+ " for the " + i + " time, my priority is: " + this.getPriority() );
		}

	}

}
