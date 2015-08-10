package com.epam.academy.exercises.unsynchronized2;

public class UnsynchronizedExample2 implements Runnable {

    static int n = 1;

    public void run() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j < 1000000; j++) {
                j = j++;
            }
            synchronized (UnsynchronizedExample2.class) {
                System.out.println(Thread.currentThread().getName() + ": " + n);
                n++;				
			}
        }
    }

    public static void main(String args[]) {
        Thread thr1 = new Thread(new UnsynchronizedExample2());
        Thread thr2 = new Thread(new UnsynchronizedExample2());

        thr1.start();
        thr2.start();

    }

}
