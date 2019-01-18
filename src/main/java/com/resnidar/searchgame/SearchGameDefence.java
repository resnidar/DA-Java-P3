package com.resnidar.searchgame;

import com.resnidar.Config;
import org.apache.log4j.Logger;

public class SearchGameDefence extends SearchGame {
    static Logger logger = Logger.getLogger(SearchGameDefence.class);

    public SearchGameDefence(Config config) {
        super(config);
    }

    /**
     * is the base of class ,if you want use this class ,it's the method to call
     * @return restart ,it's for restart or not the program at the end of the game
     */
    public boolean logic() {
        char[] userNumberChar;
        boolean restart = false;
        logger.debug("searchGame en mode defensif actif");
        System.out.println("mode logique actif");
        System.out.println("Salut ! je m'appel AiA et je serais ton adversaire pour cette partie ");
        System.out.println("AiA : Donne moi un nombre a trouver :)");
        restart = iaTurn(restart);
    return restart;
    }

    /**
     *it's the base of Ia
     * @param restart is a boolean that manages if users want restart or not at the end of game
     * @return return the restart
     */
    protected boolean iaTurn(boolean restart) {
        char restartChar;
        int win = 0;
        iaLogic(/*userNumberChar,*/ win);
        System.out.println("AIA : veut tu recommencer une partie avec moi ? y pour oui ou n pour non ");
        restartChar = sc.next().charAt(0);
        if ( restartChar == 'y')
            restart = true;
        else if (restartChar == 'n')
            restart = false;
        else
            System.out.println("erreur");
        return restart;
    }
}

// TODO: 15/01/2019 décomposé en méthode 
// TODO: 15/01/2019 organisation mere fille 
//dichotomie