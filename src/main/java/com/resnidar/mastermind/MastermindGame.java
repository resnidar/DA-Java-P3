package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.Games;

public abstract class MastermindGame extends Games implements GameLogic {
    public MastermindGame(Config config) {
        super(config);
    }

    public boolean logic(){
        return false;
    }

    /**
     *
     * @param answer an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return present : the number of present number
     */
    int present(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre qui sont present
        int present = 0;
        int[] stat = new int[expected.length];
        for (char c : answer) {
            for (int expectedIndex = 0; expectedIndex < expected.length; expectedIndex++) {
                if (c == expected[expectedIndex] && stat[expectedIndex] == 0) {
                    present++;
                    stat[expectedIndex] = 1;
                    break;
                }
            }
        }
        return present;
    }

    /**
     *
     * @param answer an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return goodPlace : the number of number at goodPlace
     */
    int goodPlace(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre a la bonne place
        int goodPlace = 0;
        for (int answerIndex = 0; answerIndex < answer.length; answerIndex++)
        {
            if (answer[answerIndex] == expected[answerIndex]){
                goodPlace++;
            }
        }
        return goodPlace;
    }
}
