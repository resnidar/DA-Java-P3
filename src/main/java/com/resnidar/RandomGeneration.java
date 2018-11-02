package com.resnidar;

public class RandomGeneration {
    int nbr = 1523;

    void countnumber() {
        int un = 0;
        int deux = 0;
        int trois = 0;
        int four = 0;
        int count = 0;
        int nbrd = nbr;
        for (int i = 0; nbrd > 1; i++) {
            if (nbrd >= 1) {
                nbrd /= 10;
                count++;
            }
        }
        System.out.println(count);
        int[] randomNumberTab = new int[count];
        nbrd = nbr;
        while(count >= 0){
            un = nbrd % 10;
            nbrd /= 10;
            System.out.println("donne" + un);
            count--;
        }
    }
}