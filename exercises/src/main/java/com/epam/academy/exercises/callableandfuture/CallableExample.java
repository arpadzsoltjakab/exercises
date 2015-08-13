package com.epam.academy.exercises.callableandfuture;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("call() method is starting and " + Thread.currentThread().getName() );
		Thread.sleep(3000);
		System.out.println("call() method is finishing and " + Thread.currentThread().getName() );
		return Thread.currentThread().getName().toString();
	}

}
