package com.resnidar;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGame extends Games {

    private static Logger logger = Logger.getLogger(SearchGame.class);

    /**
     *cette methode gère la logique du programme
     * @return permet au programme de redemarré ou non
     */
    char logic(){
        logger.debug("début du searchGame");
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        char restart;
        int life = 5;
        System.out.println("lancement du jeu : nombre secret ");
        logger.debug("appel de la class RandomGeneration");
        logger.debug("appel de randomGeneration");
        char[] randomNumberTab = randomGeneration.getRandomNumber();
        System.out.println("le nombre est composé de " + randomGeneration.getSize() + " caractères");
        interactUser(sc, life, randomNumberTab);
        System.out.println("voulez vous rejouer ? ");
        logger.debug("Scanner en attente de l user");
        restart = sc.next().charAt(0);
        logger.debug("le Scanner a receptionner les donnees ");
        return restart;
    }

    /**
     * cette fonction permet d'interargir avec l'utilisateur
     * @param sc le Scanner
     * @param life nombre de vie de l'user
     * @param randomNumberTab tableau de nombre aléatoire
     */
    private void interactUser(Scanner sc, int life, char[] randomNumberTab) {
        String proposition;
        boolean endGame = false;
        char[] userTab;
        int totalFail = 0;
        int fail = 0;
        for(int i = 0; i < life && endGame == false; i++) {
            System.out.println("trouve les bon numero :");
            logger.debug("attente de l'user");
            proposition = sc.next();
            logger.debug("proposition recu");
            userTab = proposition.toCharArray();
            logger.debug("String > tableau de char");
            try {
                logger.debug("propositionCompar : comparaison entrée utilisateur et entrée");
                fail = propositionCompar(randomNumberTab, userTab, fail, endGame);
                if (fail == 0)
                    endGame = true;
                if (fail > 0)
                    totalFail++;
                fail = 0;
            }catch (ClassCastException e){
                logger.error("method propositionCompar don't work");
            }
        }
        if (totalFail < life){
            System.out.println("\n\rbien joué ,tu a gagné");
            endGame = true;
        }
        else
            System.out.println("tu a perdu désolé");
    }

    /**
     * cette fonction permet de comparé les tableaux entres eux
     * @param randomNumberTab tableau de nombre aléatoire
     * @param userTab tableu remplie par l'utilisateur
     * @param fail le nombre de faute
     * @param endGame bool permettant de stoppé le jeu
     * @return
     */
    private int propositionCompar(char[] randomNumberTab, char[] userTab, int fail, boolean endGame) {
        for (int j = 0; j < randomNumberTab.length; j++) {
            if (randomNumberTab[j] > userTab[j]) {
                System.out.print("+");
                fail++;
            } else if (randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if (randomNumberTab[j] < userTab[j]) {
                System.out.print("-");
                fail++;
            } else
            {
                System.out.println("erreur");
                logger.error("erreur");
            }
            // TODO: 11/12/2018 mettre dans un try ?  
        }
        return fail;
    }
}
// TODO: 07/12/2018 log debbug
// TODO: 08/12/2018  log warning