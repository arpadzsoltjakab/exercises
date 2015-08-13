package com.epam.academy.exercises.semaphoreexample1;

import java.util.concurrent.Semaphore;

public class ConnectionPoolManagedBySemaphore {
	
	private final int poolSize;
	
	private final Semaphore semaphore;
	
	private final Connection[] resources;
	
	private final boolean[] used;
	
	public ConnectionPoolManagedBySemaphore(int poolSize) {
		this.poolSize = poolSize;
		semaphore = new Semaphore(poolSize);
		resources = new Connection[poolSize];
		used = new boolean[poolSize];
		for (int i = 0; i < poolSize; i++) {
			resources[i] = new Connection(i);
		}	
	}
	
    public Connection aquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException: " + ie.getMessage());
        }

        for (int i = 0; i < poolSize; i++) {
            if (used[i] == false) {
                used[i] = true;
                return resources[i];
            }
        }

        return null;
    }

    public void release(Connection resource) {
        try {
            used[resource.getId()] = false;
        } finally {
            semaphore.release();
        }
    }

}
