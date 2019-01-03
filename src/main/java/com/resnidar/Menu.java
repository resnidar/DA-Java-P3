package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {

    private final Config config;

    public Menu() {
        config = new Config();
    }

    static Logger logger = Logger.getLogger(Menu.class);
    void logic() {
        SearchGameChallenger searchGameChallender = new SearchGameChallenger(config);
        SearchGameDefence searchGameDefence = new SearchGameDefence(config);
        Boolean restart = true;
        while (restart == true) {
            System.out.println("Voici la listes des jeux : ");
            System.out.println("taper : 1 pour joué au nombre secret");
            System.out.println("taper : 2 pour joué au Mastermind");
            logger.debug("attente de l'entrer utilisateur");
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            if (result == 1) {
                System.out.println("vous avez choisi le jeu du nombre secret");
                System.out.println("quel mode de jeu voulez vous ?");
                System.out.println("taper : 1 pour le mode challenger");
                System.out.println("taper : 2 pour le mode defenseur");
                result = sc.nextInt();
                if (result == 1)
                {
                    System.out.println("lancement de searchGame en mode challenger");
                    logger.debug("lancement de Searchgame en mode challenger");
                    restart = searchGameChallender.logic();
                }
                else if (result == 2)
                {
                    System.out.println("lancement de serachGame en mode defenseur");
                    logger.debug("lancement de SearchGame en mode defenseur");
                    restart = searchGameDefence.logic();
                }
            } else if (result == 2) {
                System.out.println("vous avez choisi le jeu : mastermind");
            } else {
                System.out.println("il y a surement une erreur ,veuillez recommencé ");
                logger.error("erreur ,vous avez rentrer " + result + " veuillez entrer 1 ou 2");
            }
        }
    }
}