package com.epam.academy.exercises.executors1;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTaskMain {

	private static final int NUMBER_THREADS = 3;
	
	ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
	
	public static void main(String[] args) throws IOException {
		new MyTaskMain().startSubmittingTasks();
	}
	
	public void startSubmittingTasks() throws IOException {
		for (int i = 0; i < 10; i++) {
			executorService.execute(new MyTask(i));
		}
		executorService.shutdown();
	}

}
