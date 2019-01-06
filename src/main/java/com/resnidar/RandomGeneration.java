package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Random;

class RandomGeneration {
    private static Logger logger = Logger.getLogger(SearchGame.class);
    Config config = new Config();

    /**
     * permet de crée ,pour chaque case d un tableau ,un numero aléatoire
     * @return retourne le tableau rempli
     */
    char[] getRandomNumber(int size) {
        boolean devMod;
        int[] randomNumberTab = new int[size];
        logger.debug("tableau de int crée");
        char[] randomNumberChar = new char[size];
        logger.debug("tableau de char crée");
        for (int i = 0; i < randomNumberTab.length; i++) {
            logger.debug("numero aléatoire mis dans la case " + i + "du tableau");
            Random random = new Random();
            int number = random.nextInt(10);
            randomNumberTab[i] = number;
        }
        for (int i = 0; i < randomNumberChar.length; i++) {
            randomNumberChar[i] = (char) randomNumberTab[i];
            randomNumberChar[i] += '0';
        }
        logger.debug("return randomNumberChar");
        devMod = config.getDevMode();
        if (devMod == true){
            System.out.println("devMode : le nombre a trouver est ");
            for (int i = 0; i < randomNumberChar.length; i++) {
                System.out.print(randomNumberChar[i]);
            }
            System.out.println();
        }
        return randomNumberChar;
    }
}
// TODO: 08/12/2018  log warning