package com.epam.academy.exercises.cubbyhole;

public class Consumer implements Runnable {

	private CubbyHole cubbyHole;
	
	public Consumer(CubbyHole cubbyHole) {
		this.cubbyHole = cubbyHole;
	}

	@Override
	public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            try {
				value = cubbyHole.get(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
	}

}
