package com.epam.academy.exercises.beeptimer;

import java.util.Timer;
import java.util.TimerTask;

public class RemindTask extends TimerTask {

    int numWarningBeeps = 3;

    public void run() {
        if (numWarningBeeps > 0) {
        	System.out.println("Beep");
        	numWarningBeeps--;
        } else {
        	System.out.println("Time is up!");	
            System.exit(0);   //Stops the AWT thread (and everything else)
        }
    }
}
