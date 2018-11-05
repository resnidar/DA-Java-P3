package com.resnidar;

import java.util.Random;

class RandomGeneration {

    int[] countNumber() {
        int[] randomNumberTab = new int[6];

        for(int i = 0; i < randomNumberTab.length ; i++){
            Random random = new Random();
            int number = random.nextInt(10);
            randomNumberTab[i] = number;
        }
        return randomNumberTab;
    }
}