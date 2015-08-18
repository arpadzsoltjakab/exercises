package com.epam.academy.exercises.ReadWriteLock;

public class ReaderTask implements Runnable {
	
	private BasketWithLocks basket;
	
	public ReaderTask(BasketWithLocks basket) {
		this.basket = basket;
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				String[] values = basket.getKeysFromBasketWithReadLock();
				for(String key : values) {
					System.out.println(Thread.currentThread().getName() + " " + basket.getFromBasketWithReadLock(key));
				}
			}			
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
