package com.epam.academy.exercises.executors_submit;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyTaskMain {

	private static final int NUMBER_THREADS = 3;
	
	ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		new MyTaskMain().startSubmittingTasks();
	}
	
	public void startSubmittingTasks() throws IOException, InterruptedException, ExecutionException {
		for (int i = 0; i < 10; i++) {
			Future result = executorService.submit(new MyTask(i));
            boolean isDone = result.isDone();
            System.out.println("Task " + i + (isDone ? " has finishes execution" : " is still running"));
		}
		executorService.shutdown();
	}
}
