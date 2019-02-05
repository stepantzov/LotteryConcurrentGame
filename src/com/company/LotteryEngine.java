package com.company;

import java.util.*;

public class LotteryEngine extends Thread {
    private static volatile String lotteryWinnerName = null;
    private static List<String> names = new ArrayList<>(Arrays
            .asList("Emma", "Liam", "Olivia", "William", "Ava", "James", "Sophia", "Benjamin", "Mia", "Oliver"));

    public void definePlayingUsers() {
        System.out.println("Please enter number of lottery players below (max 10):");
        Scanner scanner = new Scanner(System.in);
        int numberOfUsers = Integer.parseInt(scanner.nextLine());

        System.out.println("Next players have join the lottery: ");
        names = createUsersList(numberOfUsers);
        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println(names.get(i));
        }
    }

    public void run() {
        while (true) {
            System.out.println();
            System.out.println("$$$ We've got new Lottery winner!!! $$$");
            System.out.println("Please log with proper user name to check the results.");
            setLotteryRandomWinnerName();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> createUsersList(int numberOfUsers) {
        Collections.shuffle(names);

        return names.subList(0, numberOfUsers);
    }

    private static void setLotteryRandomWinnerName() {
        Random rand = new Random();
        lotteryWinnerName = names.get(rand.nextInt(names.size()));
    }

    public static String getVolatileLotteryWinnerName() {

        return lotteryWinnerName;
    }

    public static List<String> getCurrentLotteryPlayersList() {
        return names;
    }
}