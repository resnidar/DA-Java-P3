package com.resnidar;

import static java.lang.Math.*;

public class RandomGeneration {
    int nbr = 1523;

    int[] countnumber() {
        double un = 0;
        int une = 0;
        int count = 0;
        int nbrd = nbr;
        while (nbrd > 0) {
            nbrd /= 10;
            count++;
        }
        System.out.println(count);
        int[] randomNumberTab = new int[count];
        count--;
        nbrd = nbr;
        while(count >= 0){
            un = nbrd % 10;
            une = (int) Math.floor(un);
            nbrd /= 10;
            System.out.println("donne" + une);
            randomNumberTab[count] = une;
            count--;
        }
        return randomNumberTab;
    }
}