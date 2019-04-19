package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Games {

    protected static int lifeStatic;
    protected int numberSize;
    protected int life;
    protected boolean devMode;
    protected int colorNumber;

    public Games (Config config) {
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
        boolean error;
        String userNumber;
        char[] userNumberChar;
        /*do {
            error = false;
            userNumber = sc.next();
            userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
            if (userNumber.length() != numberSize)
                System.err.println("Attention ! Le nombre que tu a entrée doit faire " + numberSize + " caractères, recommence");
            for (int i = 0; i < numberSize && error == false; i++){
                if (userNumberChar[i] < 48 || userNumberChar[i] > 57){
                    error = true;
                    System.err.println("Attention, il ne faut pas rentrer de caractères spéciaux ni de lettres alphabétiques");
                }
            }
        }while (userNumber.length() != numberSize || error == true);*/
        userNumberChar = controlUserNumberScanner();
        //Games.logger.debug("l user a entrée : " + userNumber);
        return userNumberChar;
    }

    /**this method asks at user if he wants to restart or not and how
     * if you want us this fonction, it's more securised to use checkingRestartChoice
     *
     * @return the byte for restart choice (1=restart/ 2=restartWithDifferentMode/3=stopTheGame)
     */
    public UserRestartChoice fonctionRestartChoice() {
        int choice;
        UserRestartChoice res = UserRestartChoice.UNKNOWN;
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
        choice = controlUserNumberScanner(1, 3);
        if (choice == 1) {
            System.out.println("AiA : c'est reparti ! ");
            res = UserRestartChoice.RESTART;
        }
        else if (choice == 2) {
            System.out.println("AiA : d'accord changeons de mode de jeu ");
            res = UserRestartChoice.CHANGE;
        }
        else if (choice == 3) {
            System.out.println("AiA : ca marche ! à plus tard");
            res = UserRestartChoice.QUIT;
        }
        else
            logger.error("il y a une erreur, l'utilisateur a rentré des données inexactes");
        return res;
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

    /**
     * @see Games#fonctionRestartChoice()
     * this method call fonctionRestartChoice and check the validity of the user response
     * this method is linked at fonctionRestartChoice.
     *
     * @return the byte for restart choice (1=restart/ 2=restartWithDifferentMode/3=stopTheGame)
     */
    public UserRestartChoice checkingUserRestartChoice() {
        boolean error = false;
        UserRestartChoice restartByte;
        do{
            if (error == true) // pourquoi variable peut être crée
                System.err.println("tu n'as pas entré un nombre entre 1 et 3, recommence");
            error = false;
            restartByte = fonctionRestartChoice();
            switch (restartByte) {
                case RESTART:
                    logger.debug("l'utilisateur a choisi de recommencé une partie");
                    break;
                case CHANGE:
                    logger.debug("l'utilisateur a choisi de changé de mode de jeu");
                    break;
                case QUIT:
                    logger.debug("l'utilisateur ferme le programme");
                    break;
                    default:
                        error = true;
                        break;
            }
        }while(error);
        return restartByte;
    }

    public int controlUserNumberScanner(int min, int max) {
        int result;
        do {
            result = 999;
            try {
                Scanner trysc = new Scanner(System.in);
                result = trysc.nextInt();
                if (result < min || result > max)
                    System.err.println("attention, tu doit entré un chiffre entre " + min + " et " + max);
            } catch (InputMismatchException e) {
                System.err.println("attention, tu doit entré un chiffre entre "+ min +" et " + max);
            }
        }while (result < min || result > max);
        return result;
    }

    public char[] controlUserNumberScanner(){
        boolean error;
        char[] userNumberChar;
        String userNumber;
        do {
            error = false;
            userNumber = sc.next();
            userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
            if (userNumber.length() != numberSize)
                System.err.println("Attention ! Le nombre que tu a entrée doit faire " + numberSize + " caractères, recommence");
            else
            for (int i = 0; i < numberSize && error == false; i++){
                if (userNumberChar[i] < 48 || userNumberChar[i] > 57){
                    error = true;
                    System.err.println("Attention, il ne faut pas rentrer de caractères spéciaux ni de lettres alphabétiques");
                }
            }
        }while (userNumber.length() != numberSize || error == true);
        return userNumberChar;
    }
}
// TODO: 06/04/2019 nom des variables soigné
// TODO: 06/04/2019 nom des methodes soigné