package com.epam.academy.exercises.unsynchronized1;

public class UnsynchronizedExample implements Runnable {

	private final String first;
	
	private final String second;
	
	public UnsynchronizedExample(String first, String secod) {
		this.first = first;
		this.second = secod;
	}

	public static void main(String[] args) {
		Thread ex1 = new Thread(new UnsynchronizedExample("Hello ", "there."));
		Thread ex2 = new Thread(new UnsynchronizedExample("How are ", "you?"));
		Thread ex3 = new Thread(new UnsynchronizedExample("Thank you ", "very much!"));
		ex1.start();
		ex2.start();
		ex3.start();
	}

	static void print(String first, String second) throws InterruptedException {
		System.out.println(first);
		Thread.sleep(500);
		System.out.println(second);
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
