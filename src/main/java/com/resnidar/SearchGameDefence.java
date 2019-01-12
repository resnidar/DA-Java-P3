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
        System.out.println("veuillez entree le nombre");
        userNumberChar = userRequest();


        //futur method iaTurn
        // TODO: 17/12/2018 demander a l ia de trouver le nombre secret
// TODO: 2019-01-08  l'ia receptionne le numero
// TODO: 2019-01-08 l ia regarde si c est au milieu

        char[] iaTab = new char[userNumberChar.length];
        char[] userPropTab = new char[userNumberChar.length];
        for (int i = 0; i < userNumberChar.length; i++) {
            iaTab[i] = '5';
        }
        for (int i = 0; i <= life; i++) { // cette boucle est limité par la vie
            System.out.print("IA : je te propose ");
            for (int j = 0; j < iaTab.length; j++)
                System.out.print(iaTab[j]);
            System.out.println(" veuillez saisir + , - ou =");
            userProp = sc.next();
            userPropTab = userProp.toCharArray();
            for (int j = 0; userNumberChar.length > j; j++) { // cette boucle permet de faire toute les cases du tab
                if (userPropTab[j] == '+') {
                    iaTab[j] += 1;
                } else if (userPropTab[j] == '-')
                    iaTab[j] -= 1;
            }
        }
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