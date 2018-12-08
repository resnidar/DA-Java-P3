package com.resnidar;


public class StringToStringInTab {

    /**
     *transforme le int
     * @param userNbr
     * @return
     */
    static char[] StringToStringInTab (String userNbr) {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] nbrTab = new char[randomGeneration.getSize()];
        for (int i = 0; i < nbrTab.length; i++) {
            nbrTab[i] = userNbr.charAt(i);
        }
        return nbrTab;
    }
}
// TODO: 07/12/2018 log