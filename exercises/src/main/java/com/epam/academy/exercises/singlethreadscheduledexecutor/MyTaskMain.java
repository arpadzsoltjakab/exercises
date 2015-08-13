package com.epam.academy.exercises.singlethreadscheduledexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;

public class MyTaskMain {

	
	public static void main(String[] args) {
		
        ScheduledExecutorService scheduledExecutedService = Executors.newSingleThreadScheduledExecutor();
		
        final ScheduledFuture<?> timeHandle = scheduledExecutedService.scheduleAtFixedRate(
                new MyTask(0),
                3, // Initial delay
                5, // the period between successive executions
        		SECONDS); //  the time unit

        
        scheduledExecutedService.schedule(new Runnable() {// This is inner class
	            @Override
	            public void run() {
	                System.out.println("Canceling timeHandle ...");
	                timeHandle.cancel(false); // mayInterruptIfRunning - true if the thread 
	                // executing this task should be interrupted; 
	                // otherwise, in-progress tasks are allowed to complete
	            }
	        }, 25 * 1, SECONDS);
        
        System.out.println("Task0 is scheduled now ");
        try {
            // Sleep for some time 30 seconds
            Thread.sleep(30*1000);
        } catch (InterruptedException ie) {
            System.out.println("Sleep was interrupted: " + ie.getMessage());
        }
        scheduledExecutedService.shutdown();
        System.out.println("Now shuting down the ScheduledExecutorService");
	}
}
