package com.epam.academy.exercises.synchronized2;

public class SynchronizedExample implements Runnable {

	private final String first;
	
	private final String second;
	
	public SynchronizedExample(String first, String secod) {
		this.first = first;
		this.second = secod;
	}

	public static void main(String[] args) {
		Thread ex1 = new Thread(new SynchronizedExample("Hello ", "there."));
		ex1.start();
		Thread ex2 = new Thread(new SynchronizedExample("How are ", "you?"));
		ex2.start();
		Thread ex3 = new Thread(new SynchronizedExample("Thank you ", "very much!"));
		ex3.start();
	}

	void print(String first, String second) throws InterruptedException {
		synchronized (this.getClass()) {
			System.out.println(first);
			Thread.sleep(500);
			System.out.println(second);			
		}
	}

	@Override
	public void run() {
		try {
			print(first, second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
