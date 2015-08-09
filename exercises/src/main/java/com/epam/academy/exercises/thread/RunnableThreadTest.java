package com.epam.academy.exercises.thread;

public class RunnableThreadTest {

	public static void main(String[] args) throws InterruptedException {
		PrintNameThread threadA = new PrintNameThread("A");
		PrintNameThread threadB = new PrintNameThread("B");
		PrintNameThread threadC = new PrintNameThread("C");
		
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
