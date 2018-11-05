package com.resnidar;

 class RandomGeneration {

    int[] countNumber() {
        int nbr = 1523;
        double un;
        int une;
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