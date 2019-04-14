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
        boolean error = false;
        int indexToListForDelete;
        logger.debug("appel de la fonction listPrep pour remplissage de la liste");
        listPrep(numberOfColor, numberSize);
        System.out.println("la liste est remplie ,le jeu commencé");
        while (!win && !loose) {
            logger.debug("appel de la fonction proposition");
            indexToListForDelete = proposition();
            goodPlace = sc.nextInt();
            System.out.println("combien y en a t il de present ?");
            logger.debug("attente de l'entrée d'un int de l'user");
            present = sc.nextInt();
            System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
            logger.debug("appel de la fonction removePossibility");
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

    // TODO: 14/04/2019 puis-je mettre un lien dans les docs?
    /**this method call fonctionRestartChoice and check the validity of the user response
     *
     * @return the byte for restart choice (1=restart/ 2=restartWithDifferentMode/3=stopTheGame)
     */
    public byte checkingUserRestartChoice() {
        boolean error;
        byte restartByte;
        do{
            if (error = true)
                System.out.println("tu n'as pas entré un nombre entre 1 et 3, recommence");
            error = false;
            restartByte = fonctionRestartChoice();
            if (restartByte == 1)
                logger.debug("l'utilisateur a choisi de recommencé une partie");
            else if (restartByte == 2)
                logger.debug("l'utilisateur a choisi de changé de mode de jeu");
            else if (restartByte == 3)
                logger.debug("l'utilisateur ferme le programme");
            else {
                error = true;
            }
        }while(error);
        return restartByte;
    }
}

// TODO: 19/02/2019 avertir utilisateur des limites
// TODO: 19/03/2019 logger