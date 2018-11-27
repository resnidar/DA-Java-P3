package com.resnidar;

import java.util.Random;

class RandomGeneration {
    Config config = new Config();
    int size = config.getNumberSize();

    char[] getRandomNumber() {
        int[] randomNumberTab = new int[size];
        char[] randomNumberChar = new char[size];
        for (int i = 0; i < randomNumberTab.length; i++) {
            Random random = new Random();
            int number = random.nextInt(10);
            randomNumberTab[i] = number;
        }
        for (int i = 0; i < randomNumberChar.length; i++) {
            randomNumberChar[i] = (char) randomNumberTab[i];
            randomNumberChar[i] += '0';
        }
        return randomNumberChar;
    }

    public int getSize() {
        return size;
    }
}