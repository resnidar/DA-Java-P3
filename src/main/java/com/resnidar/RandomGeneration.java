package com.resnidar;

import com.resnidar.searchgame.SearchGame;
import org.apache.log4j.Logger;

import java.util.Random;

public class RandomGeneration {
    String wholeNumber = "";
    private static Logger logger = Logger.getLogger(SearchGame.class);


    /**
     * creates an array of random numbers
     *
     * @return return array full
     */
    public char[] getRandomNumber(int size, boolean devMod,int numberSize) {
        int[] randomNumberTab = new int[size];
        logger.debug("tableau de int crée");
        char[] randomNumberChar = new char[size];
        logger.debug("tableau de char crée");
        for (int i = 0; i < randomNumberTab.length; i++) {
            logger.debug("numero aléatoire mis dans la case " + i + "du tableau");
            Random random = new Random();
            int number = random.nextInt(numberSize);
            randomNumberTab[i] = number;
        }
        for (int i = 0; i < randomNumberChar.length; i++) {
            randomNumberChar[i] = (char) randomNumberTab[i];
            randomNumberChar[i] += '0';
        }
        logger.debug("return randomNumberChar");
        if (devMod) {
            System.out.println("-----------------devMode-------------------");
            System.out.println("le nombre à trouver est ");
            for (char c : randomNumberChar) {
                System.out.print(c);
                wholeNumber += c;
            }
            System.out.println("\n-------------------------------------------");
        }
        return randomNumberChar;
    }

    public String getWholeNumber() {
        return wholeNumber;
    }
}

// TODO: 06/04/2019 nom des variables soigné
// TODO: 06/04/2019 nom des methodes soigné