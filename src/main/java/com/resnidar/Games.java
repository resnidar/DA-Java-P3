package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

public abstract class Games {
    static Logger logger = Logger.getLogger(SearchGame.class);

    protected int size;
    protected boolean devMode;
    protected int life;

    public Games(Config config) {
        devMode = config.getDevMode();
        size = config.getNumberSize();
        life = config.getLife();
    }

    public abstract boolean logic();

    /**
     * cette fonction permet de comparé les tableaux entres eux
     *
     * @param randomNumberTab tableau de nombre aléatoire
     * @param userTab         tableu remplie par l'utilisateur
     * @param fail            le nombre de faute
     * @return
     */
    public int propositionCompar(char[] randomNumberTab, char[] userTab, int fail) {
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
    // TODO: 22/01/2019 approfondir abstract
    // TODO: 22/01/2019 method abstraite
}