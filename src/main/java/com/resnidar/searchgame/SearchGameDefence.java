package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import org.apache.log4j.Logger;

public class SearchGameDefence extends SearchGame implements GameLogic {
    private static Logger logger = Logger.getLogger(SearchGameDefence.class);

    public SearchGameDefence(Config config) {
        super(config);
    }

    /**
     * is the base of class ,if you want use this class ,it's the method to call
     *
     * @return restart ,it's for restart or not the program at the end of the game
     */
    public byte logic() {
        byte restartByte;
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
    private byte iaTurn() {
        byte restartByte;
        iaLogic();
        restartByte = fonctionRestartChoice();
        return restartByte;
    }
}