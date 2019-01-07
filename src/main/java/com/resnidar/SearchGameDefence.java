package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGameDefence extends SearchGame {
    static Logger logger = Logger.getLogger(SearchGameDefence.class);

    public SearchGameDefence(Config config) {
        super(config);
    }
    Scanner sc = new Scanner(System.in);

    boolean logic(){
        char[] userNumberChar;
        String userNumber;
        boolean restart = false;
        logger.debug("searchGame en mode defensif actif");
        System.out.println("mode logique actif");

        //futur method userRequest
        System.out.println("veuillez entree le nombre");
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray(); //mise du string dans un tableau de char
        for (int i = 0; userNumberChar.length > i; i++){
            System.out.println("chiffre " + i +  " : " + userNumberChar[i] );
        }

        //futur method iaTurn

        return restart;
    }

}
// TODO: 17/12/2018 demander a l ia de trouver le nombre secret

