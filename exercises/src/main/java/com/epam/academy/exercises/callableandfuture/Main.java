package com.epam.academy.exercises.callableandfuture;

import java.beans.FeatureDescriptor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService scheduledExecutedService = Executors.newSingleThreadScheduledExecutor();
		System.out.println("Starting work in thread " + Thread.currentThread().getName());
		Future<String> result = scheduledExecutedService.submit(new CallableExample());
		Thread.sleep(1000);
		System.out.println("Work by main thread is done");
		System.out.println(result.get());
	}

}
