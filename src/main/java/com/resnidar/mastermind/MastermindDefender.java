package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.Scanner;

public class MastermindDefender extends MastermindGame implements GameLogic {
    private int numberOfColor;

    public MastermindDefender(Config config) {
        super(config);
        numberOfColor = config.getColorNumber();
    }

    @Override
    public byte logic() {
        byte restartByte;
        Scanner sc = new Scanner(System.in);
        int present;
        int goodPlace;
        int numberOfTurns = 0;
        boolean win = false;
        boolean loose = false;
        int indexToListForDelete;
        if (numberSize > 7 || numberOfColor > 5)
            System.out.println("attention, si vous utilisez un nombre de couleurs ou de pion trop important, " +
                    "l'ordinateur risque de mettre beaucoup de temps à trouver une réponse, " +
                    "nous vous conseillons de ne pas dépasser un nombre de pion de 7 si le nombre de couleurs " +
                    "est supérieur à 6");
        logger.debug("appel de la fonction listPrep pour remplissage de la liste");
        listPrep(numberOfColor, numberSize);
        System.out.println("AiA : J'ai rempli ma liste, on peut commencer");
        System.out.println("------------------------------------");
        while (!win && !loose) {
            logger.debug("appel de la fonction proposition");
            indexToListForDelete = proposition();
            goodPlace = sc.nextInt();
            System.out.println("combien y en a t il de present ?");
            logger.debug("attente de l'entrée d'un int de l'user");
            present = sc.nextInt();
            logger.debug("appel de la fonction removePossibility");
            for (int i = 0; i < 25; i++)
                System.out.println();
            System.out.println("AiA : Ok, je réfléchis, attend une seconde ...");
            System.out.println("------------------------------------");
            list = removePossibility(list, list.get(indexToListForDelete), numberOfTurns, goodPlace, present);
            if (goodPlace == numberSize) {
                win = true;
                System.out.println("AiA : j'ai gagné  !");
                logger.debug("l'utilisateur a gagné");
            } else {
                life--;
                System.out.print("AiA : il me reste " + life);
                if (life == 1)
                    System.out.println(" vie");
                else
                    System.out.println(" vies");
            }
            if (life == 0) {
                logger.debug("l'utilisateur a perdu");
                loose = true;
                System.out.println("AiA : Arf, j'ai perdu .... bien joué");
            }
            numberOfTurns++;
        }
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }

    // TODO: 14/04/2019 MENTOR puis-je mettre un lien dans les docs?
    /**this method call fonctionRestartChoice and check the validity of the user response
     * this method is linked at fonctionRestartChoice.
     *
     * @return the byte for restart choice (1=restart/ 2=restartWithDifferentMode/3=stopTheGame)
     */
    public byte checkingUserRestartChoice() {
        boolean error = false;
        byte restartByte;
        do{
            if (error == true) // pourquoi variable peut être crée
                System.out.println("tu n'as pas entré un nombre entre 1 et 3, recommence");
            error = false;
            restartByte = fonctionRestartChoice();
            switch (restartByte) {
                case 1:
                    logger.debug("l'utilisateur a choisi de recommencé une partie");
                    break;
                case 2 :
                    logger.debug("l'utilisateur a choisi de changé de mode de jeu");
                    break;
                case 3 :
                    logger.debug("l'utilisateur ferme le programme");
                    break;
                    default:
                        error = true;
                        break;
            }
        }while(error);
        return restartByte;
    }
}

// TODO: 19/02/2019 avertir utilisateur des limites = 7 color.6 size environ avec machine de guerre