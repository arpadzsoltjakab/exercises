package com.epam.academy.exercises.ReadWriteLock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		BasketWithLocks basket = new BasketWithLocks();
		basket.writeToBasketWithWriteLock("apple", 10);
		basket.writeToBasketWithWriteLock("orange", 20);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new WriterTask(basket));
		executor.execute(new ReaderTask(basket));
		executor.execute(new ReaderTask(basket));
		executor.execute(new ReaderTask(basket));
		executor.shutdown();
	}

}
