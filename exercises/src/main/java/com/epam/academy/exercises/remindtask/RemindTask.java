package com.epam.academy.exercises.remindtask;

import java.util.Timer;
import java.util.TimerTask;

public class RemindTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("Time's up!");
	}

}
