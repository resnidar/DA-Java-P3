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
     * @return restart ,it's for restart or not the program at the end of the game
     */
    public boolean logic() {
        boolean restart;
        for (int i = 0; i < 15; i++)
            System.out.println();
        if (devMode == true) {
            System.out.println("devMode activé");
        }
        System.out.println("AiA : pour cette partie, tu as " + life + " vies, tu peux changer ça dans le config.properties \n");
        System.out.println("AiA : Donne moi un nombre a trouver :) le nombre peut faire la taille que tu veut");
        restart = iaTurn();
    return restart;
    }

    /**
     *it's the base of Ia
     * @return return the restart
     */
    private boolean iaTurn() {
        char restartChar;
        boolean restart = false;
        iaLogic();
        System.out.println("AIA : veut tu recommencer une partie avec moi ? y pour oui ou n pour non ");
        restartChar = sc.next().charAt(0);
        if ( restartChar == 'y')
            restart = true;
        else if (restartChar == 'n')
            System.out.println("le jeu ce ferme, a bientot");
        else
            System.out.println("erreur");
        return restart;
    }
    // TODO: 04/02/2019 BUG : ne trouve pas le 3 ,seulement 2 - 4 - 2 - 4
}

// TODO: 15/01/2019 décomposé en méthode 
// TODO: 15/01/2019 organisation mere fille 
//dichotomie