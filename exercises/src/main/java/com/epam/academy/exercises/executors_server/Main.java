package com.epam.academy.exercises.executors_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws IOException {
		Executor pool = Executors.newFixedThreadPool(2);
		ServerSocket socket = new ServerSocket(8010);
		int i = 0;
		while (true) {
			pool.execute( new ConnectionHandlerTask(socket.accept(), i++));
		}
	}
}
