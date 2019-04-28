package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;
import com.resnidar.UserRestartChoice;

public class MastermindDuel extends MastermindGame implements GameLogic {
    private int numberSize;
    private int numberColor;

    public MastermindDuel(Config config) {
        super(config);
        numberSize = config.getNumberSize();
        numberColor = config.getColorNumber();
    }

    /**
     * the base of class, it's the logic.
     *
     * @return if the gameMode restart (1) / game restart with other gameMode (2) / close (3)
     */
    @Override
    public UserRestartChoice logic() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] secretNumberOfIa;
        boolean game = false;
        UserRestartChoice restartByte;
        System.out.println("bienvenue dans le mode duel");
        System.out.println("la partie commence :");
        listPrep(numberColor, numberSize);
        secretNumberOfIa = randomGeneration.getRandomNumber(numberSize, devMode, numberSize);
        System.out.println("AiA : tu commences ! propose-moi un nombre composé de : " + numberColor + " couleurs et d'une taille de " + numberSize + " caractères ");
        while (!game) {
            if (!game)
                game = userTurn(secretNumberOfIa);
            if (!game) {
                System.out.println("------------------------------------");
                System.out.println("AiA : a moi de joué !");
                game = iaTurn(secretNumberOfIa);
            }
        }
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }

    /**
     * the ia part of the game
     *
     * @return true if the ia win the game, false if game continue
     */
    private boolean iaTurn(char[] secretNumberOfIa) {
        int index;
        int goodPlace;
        int present;
        index = proposition();
        System.out.println("donne moi le nombre de nombre à la bonne place");
        goodPlace = controlUserNumberScanner(0, numberSize);
        System.out.println("donne moi le nombre de present");
        present = controlUserNumberScanner(0, numberSize);
        if (goodPlace == numberSize) {
            System.out.println("AiA : Super j'ai gagné !!! tu feras mieux la prochaine fois !");
            System.out.print("Ma combinaison secrète était ");
            for (int i = 0; i < secretNumberOfIa.length; i++)
                System.out.print(secretNumberOfIa[i]);
            System.out.println();
            return true;
        }
        removePossibility(list, list.get(index), goodPlace, present);
        return false;
    }

    /**
     * the user part of the game
     *
     * @param secretNumberOfIa it's the secretnumber of ia, the number the player has to find
     * @return true if the ia lose, false if the game continue
     */
    public boolean userTurn(char[] secretNumberOfIa) {
        boolean error;
        String userResponse;
        System.out.println("devine la combinaisont secrète : ");
        do {
            error = false;
            userResponse = String.valueOf(controlUserNumberScanner());
            for (int i = 0; i < userResponse.length() && !error; i++) {
                char numberColorChar;
                numberColorChar = (char) numberColor;
                numberColorChar += '0';
                numberColorChar--;
                if (userResponse.charAt(i) < '0' || userResponse.charAt(i) > numberColorChar) {
                    error = true;
                    System.err.println("Attention ! Le nombre que tu a entrée doit ètre compris entre 0 et " + (numberColor - 1) + ", recommence\n");
                }
            }
        } while (error);
        int present;
        int goodPlace;
        present = present(userResponse.toCharArray(), secretNumberOfIa);
        goodPlace = goodPlace(userResponse.toCharArray(), secretNumberOfIa);
        System.out.println("hmmm, il y en a " + present + " de present et " + goodPlace + " a la bonne place");
        if (goodPlace == secretNumberOfIa.length) {
            System.out.println("AiA : Mince j'ai perdu ... tu a éte plus fort que moi bien joué !");
            return true;
        }
        return false;
    }
}