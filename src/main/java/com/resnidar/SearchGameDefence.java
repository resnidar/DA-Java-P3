package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGameDefence extends SearchGame {
    static Logger logger = Logger.getLogger(SearchGameDefence.class);

    int life;

    public SearchGameDefence(Config config) {
        super(config);
        life = config.getLife();
    }

    Scanner sc = new Scanner(System.in);

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
    private boolean iaTurn(char[] userNumberChar, boolean restart) {
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

    /**
     *is the combinaison of if / else and for while for make ia smart
     * @param userNumberChar an Board of char, is the number that the ia must find
     * @param iaTab is the proposition of Ia
     * @param win if user give an = ,is équals of 1 win.4 numbers and 4 wins said all user entry is '='
     */
    private void iaMind(char[] userNumberChar, char[] iaTab, int win) {
        Config config = new Config();
        String userProp;
        char[] userPropTab;
        boolean fail;
        while (life > 0 && win != userNumberChar.length) { // cette boucle est limité par la vie
            System.out.print("AiA : je te propose ");
            for (int j = 0; j < iaTab.length; j++)
                System.out.print(iaTab[j]);
            System.out.println(" saisie  + , - ou =");
            userProp = sc.next();
            userPropTab = userProp.toCharArray();
            fail = false;
            win = 0;
            for (int j = 0; userNumberChar.length > j; j++) { // cette boucle permet de faire toute les cases du tab
                if (config.getLife() == life) {
                    if (userPropTab[j] == '+') {
                        iaTab[j] += 2;
                        fail = true;
                    } else if (userPropTab[j] == '-') {
                        iaTab[j] -= 2;
                        fail = true;
                    } else if (userPropTab[j] == '=')
                        win += 1;
                    else
                        System.out.println(" il doit y avoir une erreur");
                }
                else if (config.getLife() != life){
                    if (userPropTab[j] == '+') {
                        iaTab[j] += 1;
                        fail = true;
                    } else if (userPropTab[j] == '-') {
                        iaTab[j] -= 1;
                        fail = true;
                    } else if (userPropTab[j] == '=')
                        win += 1;
                    else
                        System.out.println(" il doit y avoir une erreur");
                }
                else
                    System.out.println("erreur");
            }
            if (fail == true)
                life -= 1;
            if (win == userNumberChar.length)
                System.out.println("AiA : j'ai gagné !");
            if (win != userNumberChar.length)
                System.out.println("il reste " + life + " vies " );
            else
                System.out.println("AiA : il me restait " + life + " vies ... j'ai gagner ;) ");
        }
    }

    /**
     * this method request an entry at user in a String and pass String in Char Board
     * @return
     */
    private char[] userRequest() {
        String userNumber;
        char[] userNumberChar;
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray(); //mise du string dans un tableau de char
        for (int i = 0; userNumberChar.length > i; i++) {
            System.out.println("chiffre " + i + " : " + userNumberChar[i]);
        }
        return userNumberChar;
    }
}

// TODO: 15/01/2019 décomposé en méthode 
// TODO: 15/01/2019 organisation mere fille 
//dichotomie