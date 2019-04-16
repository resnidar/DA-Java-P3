package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class Games {

    protected static int lifeStatic;
    protected int numberSize;
    protected int life;
    protected boolean devMode;
    protected int colorNumber;

    public Games(Config config) {
        super();
        this.numberSize = config.getNumberSize();
        this.life = config.getLife();
        lifeStatic = config.getLife();
        this.devMode = config.getDevMode();
        this.colorNumber = config.getColorNumber();
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
        do {
            userNumber = sc.next();
            if (userNumber.length() != numberSize)
                System.err.println("Attention ! Le nombre que tu a entrée doit faire " + numberSize + " caractères, recommence");
        }while (userNumber.length() != numberSize);
        userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
        Games.logger.debug("l user a entrée : " + userNumber);
        return userNumberChar;
    }

    // TODO: MENTOR 14/04/2019 est ce une bonne idée ?
    /**this method asks at user if he wants to restart or not and how
     * if you want us this fonction, it's more securised to use checkingRestartChoice
     *
     * @return the byte for restart choice (1=restart/ 2=restartWithDifferentMode/3=stopTheGame)
     */
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
            logger.error("il y a une erreur, l'utilisateur a rentré des données inexactes");
        return choiceByte;
    }

    /**
     * can convert int in string and add 0 if the number is too short
     *
     * @param numberInt the number in int
     * @param realSize  the size of the number
     * @return the number modified in String and ready for list
     */
    protected String convertIntToSringAndPreparForList(int numberInt, int realSize) {
        String number = String.valueOf(numberInt);
        String zero = "0";
        while (number.length() < realSize) {
            number = zero + number;
        }
        return number;
    }

    /**
     * For convert base 10 in base X
     *
     * @param a is the base 10 for convert to base X
     * @param b is the base X
     * @return int in base X
     */
    protected int baseConvert(int a, int b) {
        String numberConvert = Integer.toString(a, b);
        return Integer.parseInt(numberConvert);
    }
}