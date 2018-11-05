package com.resnidar;

import java.util.Random;

class RandomGeneration {
    int size = 5;
    int[] countNumber() {
        int[] randomNumberTab = new int[size];

        for(int i = 0; i < randomNumberTab.length ; i++){
            Random random = new Random();
            int number = random.nextInt(10);
            randomNumberTab[i] = number;
        }
        return randomNumberTab;
    }

    public int getSize() {
        return size;
    }
}