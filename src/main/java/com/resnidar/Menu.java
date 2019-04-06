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

    private static Logger logger = Logger.getLogger(Menu.class);

    Menu(boolean forcedDevMode) {
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
        byte restartByte = 1;
        while (restartByte != 3) {
            restartByte = 1;
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
                    while (restartByte == 1)
                        restartByte = searchGameChallenger.logic();
                } else if (result == 2) {
                    logger.debug("lancement de SearchGame en mode defenseur");
                    while (restartByte == 1)
                        restartByte = searchGameDefence.logic();
                } else if (result == 3) {
                    logger.debug("lancement de SearchGame en mode duel");
                    while (restartByte == 1)
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
                result = sc.nextInt();
                if (result == 1) {
                    logger.debug("vous avez choisi le mode de jeu challenger");
                    while (restartByte == 1)
                        restartByte = masterMindChallenger.logic();
                } else if (result == 2) {
                    logger.debug("vous avez choisi le mode de jeu defenser ");
                    while (restartByte == 1)
                        restartByte = masterMindDefender.logic();
                } else if (result == 3) {
                    logger.debug("vous avez choisi le mode de jeu Duel");
                    while (restartByte == 1)
                        restartByte = masterMindDuel.logic();
                }
            } else {
                System.err.println("il y a surement une erreur ,veuillez recommencé ");
                logger.error("erreur ,vous avez rentrer " + result + " veuillez entrer 1 ou 2");
            }
        }
    }
}

// TODO: 06/04/2019 si le joueur perd, affiché la solution
// TODO: 06/04/2019 le mode developpeur doit affiché les solutions au debut
// TODO: 06/04/2019 faire le readme expliquant comment compilé et lancer le code
// TODO: 06/04/2019 nom des variables soigné
// TODO: 06/04/2019 nom des methodes soigné
// TODO: 06/04/2019 pour la soutenance, quel point abordé ? préparation a la soutenance de validation
