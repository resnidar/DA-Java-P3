package com.resnidar;

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
    boolean logic() {
        char[] userNumberChar;
        boolean restart = false;
        logger.debug("searchGame en mode defensif actif");
        System.out.println("mode logique actif");
        System.out.println("Salut ! je m'appel AiA et je serais ton adversaire pour cette partie ");
        System.out.println("AiA : Donne moi un nombre a trouver :)");
        userNumberChar = userRequest();
        restart = iaTurn(userNumberChar, restart);
    return restart;
    }

    /**
     *it's the base of Ia
     * @param userNumberChar it's the proposition of user in a board of char
     * @param restart is a boolean that manages if users want restart or not at the end of game
     * @return return the restart
     */
    protected boolean iaTurn(char[] userNumberChar, boolean restart) {
        char[] iaTab = new char[userNumberChar.length];
        char restartChar;
        int win = 0;
        for (int i = 0; i < userNumberChar.length; i++) {
            iaTab[i] = '5';
        }
        iaMind(userNumberChar, iaTab, win);
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