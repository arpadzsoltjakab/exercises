package com.epam.academy.exercises.semaphoreexample1;

public class Connection {
	
	private int id;

	public Connection(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "connection{<" + id + ">}";
	}

	
}
