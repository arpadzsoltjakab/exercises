package com.epam.academy.exercises.executors_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ConnectionHandlerTask implements Runnable {

	private Socket socket;
	
	private int connectionID;
	
	public ConnectionHandlerTask(Socket socket, int connectionID) {
		this.socket = socket;
		this.connectionID = connectionID;
	}



	@Override
	public void run() {
		System.out.println("Connection with the " + connectionID + " started");
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msgFromClient;
            while ((msgFromClient = in.readLine()) != null) {
                System.out.println("[" + connectionID + "]: " + msgFromClient);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Connection " + connectionID + ", ended");
	}

}
