package com.epam.academy.exercises.cubbyhole;

public class Producer implements Runnable {
	
	private CubbyHole cubbyHole;
	
	public Producer(CubbyHole cubbyHole) {
		this.cubbyHole = cubbyHole;
	}
	
	@Override
	public void run() {
        for (int i = 0; i < 10; i++) {
        	try {
				cubbyHole.put(i, Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException ie) {
                System.out.println("Sleep was interrupted: " + ie.getMessage());
            }
        }
	}
}
