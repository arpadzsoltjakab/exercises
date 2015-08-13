package com.epam.academy.exercises.semaphoreexample1;

public class ResourceUserTask implements Runnable {

	private final ConnectionPoolManagedBySemaphore pool;

	private final int runCount;

	private final long hold;

	private final long pause;

	public ResourceUserTask(ConnectionPoolManagedBySemaphore pool, int runCount, long hold, long pause) {
		this.pool = pool;
		this.runCount = runCount;
		this.hold = hold;
		this.pause = pause;
	}

	@Override
	public void run() {
		try {
			Connection connection;
			for (int i = 0; i < runCount; i++) {
				
				System.out.println( Thread.currentThread().getName() + " trying to get a connection");
				
				connection = pool.aquire();
				
				System.out.println( Thread.currentThread().getName() + " acquired Connection: " + connection);				
				
				Thread.sleep(hold);
				
				System.out.println( Thread.currentThread().getName() + " releasing Connection: " + connection);	
				
				pool.release(connection);
				
				Thread.sleep(pause);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
