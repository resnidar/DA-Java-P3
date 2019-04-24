package com.resnidar;

import com.resnidar.mastermind.MastermindChallenger;
import com.resnidar.mastermind.MastermindDefender;
import com.resnidar.mastermind.MastermindDuel;
import com.resnidar.searchgame.SearchGameChallenger;
import com.resnidar.searchgame.SearchGameDefence;
import com.resnidar.searchgame.SearchGameDuel;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    protected Config config;

    private static Logger logger = Logger.getLogger(Menu.class);

    Menu(boolean forcedDevMode) {
        config = new Config(forcedDevMode);
    }

    /**
     * the base of class, it's the logic.
     */
    void logic() {
        System.out.println("devMode dans Menu = " + config.getDevMode());
        GameLogic searchGameChallenger = new SearchGameChallenger(config);
        GameLogic searchGameDefence = new SearchGameDefence(config);
        GameLogic searchGameDuel = new SearchGameDuel(config);
        GameLogic masterMindChallenger = new MastermindChallenger(config);
        GameLogic masterMindDefender = new MastermindDefender(config);
        GameLogic masterMindDuel = new MastermindDuel(config);
        UserRestartChoice restartByte = UserRestartChoice.RESTART;
        int result;
        while (restartByte != UserRestartChoice.QUIT) {
            restartByte = UserRestartChoice.RESTART;
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
            result = Games.controlUserNumberScanner(1, 2);
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
                result = Games.controlUserNumberScanner(1, 3);
                if (result == 1) {
                    logger.debug("lancement de Searchgame en mode challenger");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = searchGameChallenger.logic();
                } else if (result == 2) {
                    logger.debug("lancement de SearchGame en mode defenseur");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = searchGameDefence.logic();
                } else if (result == 3) {
                    logger.debug("lancement de SearchGame en mode duel");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = searchGameDuel.logic();
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
                result = Games.controlUserNumberScanner(1, 3);
                if (result == 1) {
                    logger.debug("vous avez choisi le mode de jeu challenger");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = masterMindChallenger.logic();
                } else if (result == 2) {
                    logger.debug("vous avez choisi le mode de jeu defenser ");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = masterMindDefender.logic();
                } else if (result == 3) {
                    logger.debug("vous avez choisi le mode de jeu Duel");
                    while (restartByte == UserRestartChoice.RESTART)
                        restartByte = masterMindDuel.logic();
                }
            } else {
                System.err.println("il y a surement une erreur ,veuillez recommencé ");
                logger.error("erreur ,vous avez rentrer " + result + " veuillez entrer 1 ou 2");
            }
        }
    }
}