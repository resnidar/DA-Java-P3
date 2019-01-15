package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGame extends Games {

    static Logger logger = Logger.getLogger(SearchGame.class);
    int life;
    Scanner sc = new Scanner(System.in);

    public SearchGame(Config config) {
        super(config);
        life = config.getLife();
    }

    /**
     *is the combinaison of if / else and for while for make ia smart
     * @param userNumberChar an Board of char, is the number that the ia must find
     * @param iaTab is the proposition of Ia
     * @param win if user give an = ,is équals of 1 win.4 numbers and 4 wins said all user entry is '='
     */
    void iaMind(char[] userNumberChar, char[] iaTab, int win) {
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
    char[] userRequest() {
        String userNumber;
        char[] userNumberChar;
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
        logger.debug("l user a entrée : " + userNumber);
        for (int i = 0; userNumberChar.length > i; i++) {
            System.out.println("chiffre " + i + " : " + userNumberChar[i]);
        }
        return userNumberChar;
    }
}