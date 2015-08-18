package com.epam.academy.exercises.ReadWriteLock;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class BasketWithLocks {

	private HashMap<String,Integer> basket = new HashMap<String, Integer>();
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	private WriteLock writeLock = lock.writeLock();
	
	private ReadLock readLock = lock.readLock();
	
	public void writeToBasketWithWriteLock(String key, Integer value){
		writeLock.lock();
		try {
			basket.put(key, value);
		} 
		finally {
			writeLock.unlock();
		}
	}

	public Integer getFromBasketWithReadLock(String key) {
		readLock.lock();
		try {
			return basket.get(key);
		} 
		finally {
			readLock.unlock();
		}		
	}
	
	public String[] getKeysFromBasketWithReadLock() {
		readLock.lock();
		try {
			String[] result = new String[basket.size()];
			basket.keySet().toArray(result);
			return result;
		} 
		finally {
			readLock.unlock();
		}			
	}
}
