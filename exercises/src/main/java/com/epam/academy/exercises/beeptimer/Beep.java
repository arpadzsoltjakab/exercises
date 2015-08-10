package com.epam.academy.exercises.beeptimer;

import java.util.Timer;

public class Beep {
	private Timer timer;
	
    public Beep() {
        timer = new Timer();
        RemindTask task = new RemindTask();
        timer.schedule(task, 0, 1*1000);
    }

	public static void main(String[] args) {
        System.out.println("About to schedule Reminder task in 5 seconds");
        new Beep();
        System.out.println("Task scheduled.");
	}

}
