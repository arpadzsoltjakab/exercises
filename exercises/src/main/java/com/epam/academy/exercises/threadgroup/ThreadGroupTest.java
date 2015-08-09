package com.epam.academy.exercises.threadgroup;

public class ThreadGroupTest {

	public static void main(String[] args) {
		PrintNameThread boston = new PrintNameThread("Boston");
		PrintNameThread newYork = new PrintNameThread("New York");
		PrintNameThread tokyo = new PrintNameThread("Tokyo");
		boston.setPriority(1);
		tokyo.setPriority(5);
		newYork.setPriority(10);
		
		boston.start();
		newYork.start();
		tokyo.start();
		
		ThreadGroup tg = Thread.currentThread().getThreadGroup();
		int numberOfThreads = tg.activeCount();
		Thread[] threadList = findAllThreads();
		System.out.println("The number of Threads is : " + threadList.length);
		for ( int i = 0; i < threadList.length; i++) {
			System.out.println("The " + (i+1) + ". thread is: " + threadList[i].getName() + " In the "+
					threadList[i].getThreadGroup().getName() + " thread group.");
		}
	}
	
	public static Thread[] findAllThreads(){
		ThreadGroup globalThreadGroup = Thread.currentThread().getThreadGroup();
		
		while(globalThreadGroup.getParent()!=null){
			globalThreadGroup = globalThreadGroup.getParent();
		}
		
		int numberOfThreads = globalThreadGroup.activeCount();
		
		Thread[] threadList = new Thread[numberOfThreads];
		globalThreadGroup.enumerate(threadList);	
		
		return threadList;
	}

}
