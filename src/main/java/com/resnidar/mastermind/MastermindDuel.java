package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;
import com.resnidar.UserRestartChoice;

public class MastermindDuel extends MastermindGame implements GameLogic {
    int numberSize;
    int numberColor;

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
        System.out.println("aia : tu commence ! propose moi un nombre : ");
        while (!game) {
            if (!game)
            game = userTurn(secretNumberOfIa);
            if (!game) {
                System.out.println("aia : a moi de joué !");
                game = iaTurn(secretNumberOfIa);
            }
        }
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }

    /**
     * the ia part of the game
     * @return true if the ia win the game, false if game continue
     */
    private boolean iaTurn(char[] secretNumberOfIa) {
        int index;
        int goodPlace;
        int present;
        System.out.println("aia : c'est a moi");
        index = proposition();
        System.out.println("donne moi le nombre de nombre a la bonne place");
        goodPlace = controlUserNumberScanner(0, 9);
        System.out.println("donne moi le nombre de present");
        present = controlUserNumberScanner(0, 9);
        if (goodPlace == numberSize) {
            System.out.println("AiA : Super j'ai gagné !!! tu feras mieux la prochaine fois !");
            System.out.print("ma combinaisont secrète était ");
            for (int i = 0; i < secretNumberOfIa.length; i++)
                System.out.print(secretNumberOfIa[i]);
            System.out.println();
            return true;
        }
        removePossibility(list, list.get(index), 0, goodPlace, present);
        return false;
    }

    /**
     * the user part of the game
     * @param secretNumberOfIa it's the secretnumber of ia, the number the player has to find
     * @return true if the ia lose, false if the game continue
     */
    public boolean userTurn(char[] secretNumberOfIa) {
        System.out.println("devine la combinaisont secrète : ");
        String userResponse = sc.next();
        // TODO: 19/04/2019 protection string
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

// TODO: 15/01/2019 sécurisé le code pour évité que l user rentre n importe quoi
