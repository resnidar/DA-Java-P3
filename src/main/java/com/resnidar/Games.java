package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class Games {

    protected static int lifeStatic;
    protected int numberSize;
    protected int life;
    protected boolean devMode;

    public Games(Config config) {
        super();
        this.numberSize = config.getNumberSize();
        this.life = config.getLife();
        lifeStatic = config.getLife();
        this.devMode = config.getDevMode();
    }

    static public Logger logger = Logger.getLogger(SearchGame.class);
    private Scanner sc = new Scanner(System.in);
    public RandomGeneration randomGeneration = new RandomGeneration();

    /**
     * cette fonction permet de comparé les tableaux entres eux
     *
     * @param randomNumberTab tableau de nombre aléatoire
     * @param userTab         tableu remplie par l'utilisateur
     * @param fail            le nombre de faute
     * @return the number of dismatch in randomNumberTab and userTab
     */
    protected int propositionCompar(char[] randomNumberTab, char[] userTab, int fail) {
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
     * this method request an entry at user in a String and pass String in Char array
     *
     * @return number of user in a char array
     */
    protected char[] userRequest() {
        String userNumber;
        char[] userNumberChar;
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
        Games.logger.debug("l user a entrée : " + userNumber);
        return userNumberChar;
    }

    public byte fonctionRestartChoice() {
        byte choiceByte;
        this.life = lifeStatic;
        System.out.println("AiA : veux-tu refaire une partie avec moi de ce jeu ou d'un autre mode de jeu ?");
        System.out.println("------------------------------------");
        System.out.println("taper : 1 pour recommencer une partie");
        System.out.println("------------------------------------");
        System.out.println("taper : 2 pour changer de mode de jeu");
        System.out.println("------------------------------------");
        System.out.println("taper : 3 pour quitter le programme");
        System.out.println("------------------------------------");
        logger.debug("débug : Scanner en attente de l user");
        choiceByte = sc.nextByte();
        if (choiceByte == 1)
            System.out.println("AiA : c'est reparti ! ");
        else if (choiceByte == 2)
            System.out.println("AiA : d'accord changeons de mode de jeu ");
        else if (choiceByte == 3)
            System.out.println("AiA : ca marche ! à plus tard");
        else
            System.err.println("il y a une erreur, il faut rentré 1, 2 ou 3");
        return choiceByte;
    }
    // TODO: 18/12/2018 faire verif endtest
    // TODO: 22/01/2019 approfondir abstract
}