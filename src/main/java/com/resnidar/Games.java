package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

public class Games {
    static Logger logger = Logger.getLogger(SearchGame.class);

    protected final int size;
    protected boolean devMode;

    public Games(Config config) {
        devMode = config.getDevMode();
        size = config.getNumberSize();
    }

    /**
     * cette fonction permet de comparé les tableaux entres eux
     *
     * @param randomNumberTab tableau de nombre aléatoire
     * @param userTab         tableu remplie par l'utilisateur
     * @param fail            le nombre de faute
     * @param endGame         bool permettant de stoppé le jeu
     * @return
     */
    public int propositionCompar(char[] randomNumberTab, char[] userTab, int fail, boolean endGame) {
        for (int j = 0; j < randomNumberTab.length; j++) {
            if (randomNumberTab[j] > userTab[j]) {
                System.out.print("+");
                fail++;
            } else if (randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if (randomNumberTab[j] < userTab[j]) {
                System.out.print("-");
                fail++;
            } else {
                System.out.println("erreur");
                logger.error("erreur");
            }
        }
        return fail;
    }
    // TODO: 18/12/2018 faire verif endtest
    // TODO: 18/12/2018 control erreur
}