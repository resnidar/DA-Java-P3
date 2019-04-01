package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGameChallenger extends SearchGame implements GameLogic{
    static Logger logger = Logger.getLogger(SearchGameChallenger.class);

    public SearchGameChallenger(Config config) {
        super(config);

    }

    /**
     *cette methode gère la logique du programme
     * @return permet au programme de redemarré ou non
     */
    public boolean logic(){
        for (int i = 0; i < 20; i++)
            System.out.println();
        if (devMode)
        System.out.println("le devMode est activé ");
        System.out.println("AiA : pour cette partie, tu as " + life +" vies, tu peux changer ça dans le config.properties \n");
        logger.debug("débug : début du jeu searchGameChallenger");
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        int restartInt;
        boolean restart = false;
        System.out.println("AiA : c'est parti !");
        logger.debug("débug : appel de la class RandomGeneration");
        char[] randomNumberTab = randomGeneration.getRandomNumber(numberSize, devMode);
        System.out.println("AiA : le nombre que j'ai choisi est que tu dois trouver est composé de  " + numberSize + " caractères" +
                "\nbonne chance !\n");
        userInteract(life, randomNumberTab);
        System.out.println("AiA : veux-tu refaire une partie avec moi de ce jeu ou d'un autre mode de jeu ?");
        System.out.println("------------------------------------");
        System.out.println("taper : 1 pour recommencer une partie");
        System.out.println("------------------------------------");
        System.out.println("taper : 2 pour fermer le jeu");
        System.out.println("------------------------------------");
        logger.debug("débug : Scanner en attente de l user");
        restartInt = sc.nextInt();
        if (restartInt == 1)
            restart = true;
        logger.debug("débug : le Scanner a receptionner les donnees ");
        return restart;
    }
}
