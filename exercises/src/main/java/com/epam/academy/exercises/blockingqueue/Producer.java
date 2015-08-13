package com.epam.academy.exercises.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private final BlockingQueue<String> messageQueue;
	
	private final int id;
	
	private final int count;
	
	private final long pause;
	
	public Producer(BlockingQueue<String> messageQueue, int id, int count, long pause) {
		this.messageQueue = messageQueue;
		this.id = id;
		this.count = count;
		this.pause = pause;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < count; i++) {
				String message = "Producer ID = " + id 
						+ ", message number = " + i + " [" + Thread.currentThread().getName() + "]";				
				messageQueue.put(message);
			Thread.sleep(pause);
		}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
