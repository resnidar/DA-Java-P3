package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import org.apache.log4j.Logger;

public class SearchGameChallenger extends SearchGame implements GameLogic {
    static Logger logger = Logger.getLogger(SearchGameChallenger.class);
    //RandomGeneration randomGeneration = new RandomGeneration();
    public String wholeNumber = randomGeneration.getWholeNumber();

    public SearchGameChallenger(Config config) {
        super(config);
    }


    /**
     * cette methode gère la logique du programme
     *
     * @return permet au programme de redemarré ou non
     */
    public byte logic() {
        byte restartChoice;
        for (int i = 0; i < 20; i++)
            System.out.println();
        if (devMode)
            System.out.println("le devMode est activé ");
        System.out.println("AiA : pour cette partie, tu as " + life + " vies, tu peux changer ça dans le config.properties \n");
        logger.debug("débug : début du jeu searchGameChallenger");
        System.out.println("AiA : c'est parti !");
        logger.debug("débug : appel de la class RandomGeneration");
        char[] randomNumberTab = randomGeneration.getRandomNumber(numberSize, devMode);
        System.out.println("AiA : le nombre que j'ai choisi est que tu dois trouver est composé de  " + numberSize + " caractères" +
                "\nbonne chance !\n");
        userInteract(life, randomNumberTab);
        restartChoice = fonctionRestartChoice();
        logger.debug("débug : le Scanner a receptionner les donnees ");
        return restartChoice;
    }

}
