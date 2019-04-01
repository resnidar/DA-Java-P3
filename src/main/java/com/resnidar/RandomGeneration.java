package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.Random;

public class RandomGeneration  {
    private static Logger logger = Logger.getLogger(SearchGame.class);

    /**
     * permet de crée ,pour chaque case d un tableau ,un numero aléatoire
     * @return retourne le tableau rempli
     */
    public char[] getRandomNumber(int size, boolean devMod) {
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
        if (devMod){
            System.out.println("-----------------devMode-------------------");
            System.out.println("le nombre a trouver est ");
            for (char c : randomNumberChar) {
                System.out.print(c);
            }
            System.err.println("\n-------------------------------------------");
        }
        return randomNumberChar;
    }
}
// TODO: 08/12/2018  log warning