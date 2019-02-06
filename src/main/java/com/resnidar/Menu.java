package com.resnidar;

import com.resnidar.mastermind.MastermindChallenger;
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
                System.out.println("taper : 3 pour le mode duel");
                result = sc.nextInt();
                if (result == 1) {
                    System.out.println("lancement de searchGame en mode challenger");
                    logger.debug("lancement de Searchgame en mode challenger");
                    restart = searchGameChallenger.logic();
                } else if (result == 2) {
                    System.out.println("lancement de serachGame en mode defenseur");
                    logger.debug("lancement de SearchGame en mode defenseur");
                    restart = searchGameDefence.logic();
                } else if (result == 3) {
                    System.out.println("lancement de SearchGame en mode duel");
                    restart = searchGameDuel.logic();
                }
            } else if (result == 2) {
                System.out.println("vous avez choisi le jeu : mastermind");
                result = sc.nextInt();
                if (result == 1) {
                    System.out.println("vous avez choisi le mode de jeu challenger");
                    masterMindChallenger.logic();
                } else if (result == 2) {
                    System.out.println("vous avez choisi le mode de jeu defenser \n " +
                            "mais le mode n est pas encore disponible ,attendre une prochaine mise a jour");
                }
            } else {
                System.out.println("il y a surement une erreur ,veuillez recommencé ");
                logger.error("erreur ,vous avez rentrer " + result + " veuillez entrer 1 ou 2");
            }
        }
    }
}