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

    boolean logic() {
        char[] userNumberChar;
        String userNumber;
        String userProp;
        boolean restart = false;
        logger.debug("searchGame en mode defensif actif");
        System.out.println("mode logique actif");
        System.out.println("Salut ! je m'appel AiA et je serais ton adversaire pour cette partie ");
        System.out.println("AiA : Donne moi un nombre a trouver :)");
        userNumberChar = userRequest();


        //futur method iaTurn
        // TODO: 17/12/2018 demander a l ia de trouver le nombre secret
// TODO: 2019-01-08  l'ia receptionne le numero
// TODO: 2019-01-08 l ia regarde si c est au milieu

        restart = iaTurn(userNumberChar, restart);

// TODO: 2019-01-08 l ia regarde si c est 1/4
// TODO: 2019-01-08 l ia regarde si c est 3/4
// TODO: 2019-01-08 l ia affine
// TODO: 2019-01-08 l'ia dit qu il a trouver le nombre en X tour
// TODO: 2019-01-08 le logiciel considère la partie fini et lance le process
// TODO: 2019-01-08 decomposé en method
// TODO: 2019-01-08 organisé mere / fille
// TODO: 2019-01-08 doc !!
        return restart;
    }

    private boolean iaTurn(char[] userNumberChar, boolean restart) {
        char[] iaTab = new char[userNumberChar.length];
        char[] userPropTab = new char[userNumberChar.length];
        char restartChar;
        boolean fail = false;
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

//dichotomie