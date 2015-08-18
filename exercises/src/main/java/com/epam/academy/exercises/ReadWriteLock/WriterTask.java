package com.epam.academy.exercises.ReadWriteLock;

import java.util.Random;

public class WriterTask implements Runnable {

	private BasketWithLocks basket;
	
	public WriterTask(BasketWithLocks basket) {
		this.basket = basket;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				String[] values = basket.getKeysFromBasketWithReadLock();
				for(String key : values) {
					Integer newValue = (new Random()).nextInt(10);
					basket.writeToBasketWithWriteLock(key, newValue);
				}
			}			
			Thread.sleep((long)Math.random()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
