package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LotteryEngine lotteryEngine = new LotteryEngine();
        lotteryEngine.definePlayingUsers();
        lotteryEngine.start();

        List<String> names = lotteryEngine.getCurrentLotteryPlayersList();
        for (int i = 0; i < names.size(); i++) {
            new UserThreads(names.get(i)).start();
        }
    }
}