package com.epam.academy.exercises.thread;

public class RunnableThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		PrintNameRunnable A = new PrintNameRunnable();
		PrintNameRunnable B = new PrintNameRunnable();
		PrintNameRunnable C = new PrintNameRunnable();
		
		
		Thread threadA = new Thread(A,"A");
		Thread threadB = new Thread(A,"B");
		Thread threadC = new Thread(A,"C");
		
		System.out.println("Running threads...");
		threadA.start();
		threadB.start();
		threadC.start();
		threadC.join();
		threadA.join();
		threadB.join();
		System.out.println("All threads finished.");
	}

}
