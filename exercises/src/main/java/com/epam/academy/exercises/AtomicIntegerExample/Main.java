package com.epam.academy.exercises.AtomicIntegerExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 20; i++) {
			executorService.submit(new MyRunnableTask(i));
		}

	}

}
