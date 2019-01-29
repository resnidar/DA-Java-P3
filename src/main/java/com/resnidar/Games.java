package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class Games {
    static public Logger logger = Logger.getLogger(SearchGame.class);
    Scanner sc = new Scanner(System.in);

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

    /**
     * this method request an entry at user in a String and pass String in Char Board
     * @return
     */
    public char[] userRequest() {
        String userNumber;
        char[] userNumberChar;
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
        Games.logger.debug("l user a entrée : " + userNumber);
        return userNumberChar;
    }
    // TODO: 18/12/2018 faire verif endtest
    // TODO: 18/12/2018 control erreur
    // TODO: 22/01/2019 approfondir abstract
    // TODO: 22/01/2019 method abstraite
}