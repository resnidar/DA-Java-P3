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
}
