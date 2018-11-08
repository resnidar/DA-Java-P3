package com.resnidar;

public class UserTabProcess {
    String userNbr;

    char[] userTabProcess() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] nbrTab = new char[randomGeneration.getSize()];
        for (int i = 0; i < nbrTab.length; i++) {
            nbrTab[i] = userNbr.charAt(i);
        }
        return nbrTab;
    }

    public void setUserNbr(String userNbr) {
        this.userNbr = userNbr;
    }

    /** int[] userTabProcess() {
        double un;
        int une;
        int count = 0;
        int nbrd = nbr;
        while (nbrd > 0) {
            nbrd /= 10;
            count++;
        }
        System.out.println(count);
        int[] userTab = new int[count];
        count--;
        nbrd = nbr;
        while(count >= 0){
            un = nbrd % 10;
            une = (int) Math.floor(un);
            nbrd /= 10;
            userTab[count] = une;
            count--;
        }
        return userTab;
    }

    public void setNbr(int nbr) {
            this.nbr = nbr;
    }
    **/
}
