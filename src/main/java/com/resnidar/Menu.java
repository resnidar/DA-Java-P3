package com.resnidar;

import com.resnidar.mastermind.MastermindChallenger;
import com.resnidar.mastermind.MastermindDefender;
import com.resnidar.mastermind.MastermindDuel;
import com.resnidar.searchgame.SearchGameChallenger;
import com.resnidar.searchgame.SearchGameDefence;
import com.resnidar.searchgame.SearchGameDuel;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Menu {
    protected Config config;

    static Logger logger = Logger.getLogger(Menu.class);

    public Menu(boolean forcedDevMode) {
        config = new Config(forcedDevMode);
    }

    void logic() {
        System.out.println("devMode dans Menu = " + config.getDevMode());
        GameLogic searchGameChallenger = new SearchGameChallenger(config);
        GameLogic searchGameDefence = new SearchGameDefence(config);
        GameLogic searchGameDuel = new SearchGameDuel(config);
        GameLogic masterMindChallenger = new MastermindChallenger(config);
        GameLogic masterMindDefender = new MastermindDefender(config);
        GameLogic masterMindDuel = new MastermindDuel(config);
        Boolean restart = true;
        while (restart == true) {
            for (int i = 0; i < 50; i++)
                System.out.println();
            System.out.println("Voici la listes des jeux : ");
            System.out.println("------------------------------------");
            System.out.println("taper : 1 pour jouer au nombre secret :\n\nle but du jeu est de trouver ou faire trouver " +
                    "le bon nombre aidé des signes +, - ou =. \n" +
                    "attention vous avez un nombre de vies limité.");
            System.out.println("------------------------------------");
            System.out.println("taper : 2 pour jouer au Mastermind :\n\nle but du jeu est de trouver ou faire trouver le code secret" +
                    " détenu par l'adversaire,\nvous n'aurez comme aide que le nombre de couleurs" +
                    " (représenté par des chiffres) présents ou à la bonne place ");
            logger.debug("attente de l'entrer utilisateur.");
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();
            for (int i = 0; i < 10; i++)
                System.out.println();
            if (result == 1) {
                System.out.println("vous avez choisi le jeu du nombre secret\n");
                System.out.println("quel mode de jeu voulez vous ?");
                System.out.println("------------------------------------");
                System.out.println("taper : 1 pour le mode challenger" +
                        "\n\nvous devrez deviner le nombre secret détenu par l'ordinateur");
                System.out.println("------------------------------------");
                System.out.println("taper : 2 pour le mode défenseur" +
                        "\n\nvous devrez choisir un nombre que l'ordinateur devra trouver");
                System.out.println("------------------------------------");
                System.out.println("taper : 3 pour le mode duel" +
                        "\n\nc'est un mélange des modes défenseur et challenger, vous jouerez chacun de votre tour vous" +
                        " et l'ordinateur");
                System.out.println("------------------------------------");
                result = sc.nextInt();
                if (result == 1) {
                    logger.debug("lancement de Searchgame en mode challenger");
                    restart = searchGameChallenger.logic();
                } else if (result == 2) {
                    logger.debug("lancement de SearchGame en mode defenseur");
                    restart = searchGameDefence.logic();
                } else if (result == 3) {
                    logger.debug("lancement de SearchGame en mode duel");
                    restart = searchGameDuel.logic();
                }
            } else if (result == 2) {
                System.out.println("vous avez choisi le jeu Mastermind\n");
                System.out.println("quel mode de jeu voulez vous ?");
                System.out.println("------------------------------------");
                System.out.println("taper : 1 pour le mode challenger" +
                        "\n\nvous devrez deviner la combinaison secrète détenu par l'ordinateur");
                System.out.println("------------------------------------");
                System.out.println("taper : 2 pour le mode défenseur" +
                        "\n\nvous devrez choisir une combinaison secrète que l'ordinateur devra trouver");
                System.out.println("------------------------------------");
                System.out.println("taper : 3 pour le mode duel" +
                        "\n\nc'est un mélange des modes défenseur et challenger, vous jouerez chacun de votre tour vous" +
                        " et l'ordinateur");
                System.out.println("------------------------------------");
                result = sc.nextInt();
                if (result == 1) {
                    logger.debug("vous avez choisi le mode de jeu challenger");
                    restart = masterMindChallenger.logic();
                } else if (result == 2) {
                    logger.debug("vous avez choisi le mode de jeu defenser ");
                    restart = masterMindDefender.logic();
                }
                else if (result == 3){
                    logger.debug("vous avez choisi le mode de jeu Duel");
                    restart = masterMindDuel.logic();
                }
            } else {
                System.err.println("il y a surement une erreur ,veuillez recommencé ");
                logger.error("erreur ,vous avez rentrer " + result + " veuillez entrer 1 ou 2");
            }
        }
    }
}