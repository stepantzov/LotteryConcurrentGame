package com.company;

public class UserThreads extends Thread {
    String name;
    Thread t;

    UserThreads(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.format("Hi, %s, checking the lottery results. \n", t.getName());
        System.out.println("The winner is: " + LotteryEngine.getVolatileLotteryWinnerName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}