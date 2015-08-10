package com.epam.academy.exercises.remindtask;

import java.util.Timer;

public class TimerReminder {
	private Timer timer;
	
    public TimerReminder(int seconds) {
        timer = new Timer();
        RemindTask task = new RemindTask();
        timer.schedule(task, seconds * 1000);
        while( (task.scheduledExecutionTime() - System.currentTimeMillis() ) > 0 ) {
        }
        timer.cancel();
    }

	public static void main(String[] args) {
        System.out.println("About to schedule Reminder task in 5 seconds");
        new TimerReminder(1);
        System.out.println("Task scheduled.");
	}

}
