package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LotteryEngine lotteryEngine = new LotteryEngine();
        lotteryEngine.definePlayingUsers();
        lotteryEngine.start();

        System.out.println();
        while (true) {
            System.out.println("If you want to check the result please log to the system by entering correct user name from above: ");
            String userLogin = scanner.nextLine();
            if (LotteryEngine.getCurrentLotteryPlayersList().contains(userLogin)) {
                new UserThreads(userLogin);
            } else System.out.println("Please log with valid lottery participant name.");
        }
    }
}