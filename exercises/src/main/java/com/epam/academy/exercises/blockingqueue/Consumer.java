package com.epam.academy.exercises.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<String> messageQueue;
	
	public Consumer(BlockingQueue<String> queue) {
		this.messageQueue = queue;
	}



	@Override
	public void run() {
        try {
            while (true) {
                System.out.println("Retrieved: " + messageQueue.take());
            }
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException: " + ie);
        }
	}

}
