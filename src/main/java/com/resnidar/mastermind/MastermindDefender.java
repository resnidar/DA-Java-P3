package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.UserRestartChoice;


public class MastermindDefender extends MastermindGame implements GameLogic {
    private int numberOfColor;

    public MastermindDefender(Config config) {
        super(config);
        numberOfColor = config.getColorNumber();
    }

    /**
     * the base of class, it's the logic.
     *
     * @return if the gameMode restart (1) / game restart with other gameMode (2) / close (3)
     */
    @Override
    public UserRestartChoice logic() {
        UserRestartChoice restartByte;
        int present;
        int goodPlace;
        boolean win = false;
        boolean loose = false;
        int indexToListForDelete;
        if (numberSize > 7 && numberOfColor > 5) {
            System.out.println("attention, si vous utilisez un nombre de couleurs ou de pion trop important, " +
                    "l'ordinateur risque de mettre beaucoup de temps à trouver une réponse, " +
                    "nous vous conseillons de ne pas dépasser un nombre de pion de 7 si le nombre de couleurs " +
                    "est supérieur à 6");
        }
        logger.debug("appel de la fonction listPrep pour remplissage de la liste");
        listPrep(numberOfColor, numberSize);
        System.out.println("AiA : J'ai rempli ma liste, on peut commencer");
        System.out.println("------------------------------------");
        while (!win && !loose) {
            logger.debug("appel de la fonction proposition");
            indexToListForDelete = proposition();
            goodPlace = controlUserNumberScanner(0, numberSize);
            System.out.println("combien y en a t il de present ?");
            logger.debug("attente de l'entrée d'un int de l'user");
            present = controlUserNumberScanner(0, numberSize);
            logger.debug("appel de la fonction removePossibility");
            for (int i = 0; i < 25; i++)
                System.out.println();
            System.out.println("AiA : Ok, je réfléchis, attend une seconde ...");
            System.out.println("------------------------------------");
            list = removePossibility(list, list.get(indexToListForDelete), goodPlace, present);
            if (goodPlace == numberSize) {
                win = true;
                System.out.println("AiA : j'ai gagné  !");
                logger.debug("l'utilisateur a gagné");
            } else if (list.size() == 0) {
                life = 0;
            } else {
                life--;
                System.out.print("AiA : il me reste " + life);
                if (life == 1)
                    System.out.println(" vie");
                else
                    System.out.println(" vies");
            }
            if (life == 0) {
                logger.debug("l'ia a perdu");
                loose = true;
                System.out.println("AiA : Arf, j'ai perdu .... bien joué");
            }
        }
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }

}