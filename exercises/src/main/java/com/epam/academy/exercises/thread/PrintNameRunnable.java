package com.epam.academy.exercises.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNameRunnable implements Runnable {
	
	private volatile AtomicInteger i = new AtomicInteger(0);
	
	private final Lock lock = new ReentrantLock();

	
	@Override
	public void run() {
		while(i.get() < 10) {
			try {
				Thread.sleep((long)(Math.random()*30));
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			lock.lock();
			if(i.get() < 10){
				System.out.println("Hello, my name is: " + Thread.currentThread().getName() + " for the " + i + " time.");	
				i.incrementAndGet();
			}
			lock.unlock();
		}

	}

}
