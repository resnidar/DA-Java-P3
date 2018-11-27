package com.resnidar;


public class UserTabProcess {

    static char[] userTabProcess(String userNbr) {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] nbrTab = new char[randomGeneration.getSize()];
        for (int i = 0; i < nbrTab.length; i++) {
            nbrTab[i] = userNbr.charAt(i);
        }
        return nbrTab;
    }
}
