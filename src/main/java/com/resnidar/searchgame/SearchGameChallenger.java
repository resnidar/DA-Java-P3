package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGameChallenger extends SearchGame implements GameLogic{
    static Logger logger = Logger.getLogger(SearchGameChallenger.class);

    /*int life;*/
    public SearchGameChallenger(Config config) {
        super(config);
        /*life = config.getLife();*/
    }

    /**
     *cette methode gère la logique du programme
     * @return permet au programme de redemarré ou non
     */
    public boolean logic(){
        logger.debug("début du searchGame");
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        char restartChar;
        boolean restart = false;
        System.out.println("lancement du jeu : nombre secret ");
        logger.debug("appel de la class RandomGeneration");
        logger.debug("appel de randomGeneration");
        char[] randomNumberTab = randomGeneration.getRandomNumber(size);
        System.out.println("le nombre est composé de " + size + " caractères");
        userInteract(life, randomNumberTab);
        System.out.println("voulez vous rejouer ? y/n ");
        logger.debug("Scanner en attente de l user");
        restartChar = sc.next().charAt(0);
        if (restartChar == 'y')
            restart = true;
        if (restartChar == 'n')
            restart = false;
        logger.debug("le Scanner a receptionner les donnees ");
        return restart;
    }
}
