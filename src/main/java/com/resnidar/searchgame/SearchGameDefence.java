package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.UserRestartChoice;

public class SearchGameDefence extends SearchGame implements GameLogic {

    public SearchGameDefence(Config config) {
        super(config);
    }

    /**
     * is the base of class ,if you want use this class ,it's the method to call
     *
     * @return restart ,it's for restart or not the program at the end of the game
     */
    public UserRestartChoice logic() {
        UserRestartChoice restartByte;
        for (int i = 0; i < 15; i++)
            System.out.println();
        if (devMode) {
            System.out.println("devMode activé");
        }
        System.out.println("AiA : pour cette partie, tu as " + life + " vies, tu peux changer ça dans le config.properties \n");
        System.out.println("AiA : Donne moi un nombre a trouver :) le nombre doit faire " + numberSize + " caractères");
        restartByte = iaTurn();
        return restartByte;
    }

    /**
     * it's the base of Ia
     *
     * @return return the restart
     */
    private UserRestartChoice iaTurn() {
        UserRestartChoice restartByte;
        iaLogic();
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }
}