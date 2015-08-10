package com.epam.academy.exercises.cubbyhole;

public class ProducerConsumerUnsynchronized {

	public static void main(String[] args) {
		
		CubbyHole cubbyHole = new CubbyHole();
		
		Thread consumer = new Thread( new Consumer(cubbyHole), "Consumer");
		Thread producer = new Thread( new Producer(cubbyHole), "Producer");
		
		consumer.start();
		producer.start();
	}	
}
