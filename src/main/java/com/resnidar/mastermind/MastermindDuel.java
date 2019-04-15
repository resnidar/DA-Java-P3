package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

public class MastermindDuel extends MastermindGame implements GameLogic {
    int numberSize;
    int numberColor;

    public MastermindDuel(Config config) {
        super(config);
        numberSize = config.getNumberSize();
        numberColor = config.getColorNumber();
    }

    @Override
    public byte logic() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] secretNumberOfIa;
        boolean game = false;
        byte restartByte;
        System.out.println("bienvenue dans le mode duel");
        System.out.println("la partie commence :");
        listPrep(numberColor, numberSize);
        secretNumberOfIa = randomGeneration.getRandomNumber(numberSize, devMode, numberSize);
        System.out.println("aia : tu commence ! propose moi un nombre : ");
        for (int turn = 0; turn < 10 || !game; turn++) { // TODO: 26/03/2019 nombre de tour !!!
            if (!game)
            game = userTurn(secretNumberOfIa);
            if (!game) {
                System.out.println("aia : a moi de joué !");
                game = iaTurn();
            }
        }
        restartByte = fonctionRestartChoice();
        return restartByte;
    }

    private boolean iaTurn() {
        int index;
        int goodPlace;
        int present;
        System.out.println("aia : c'est a moi");
        index = proposition();
        System.out.println("donne moi le nombre de nombre a la bonne place");
        goodPlace = sc.nextInt();
        System.out.println("donne moi le nombre de present");
        present = sc.nextInt();
        if (goodPlace == numberSize) {
            System.out.println("AiA : Super j'ai gagné !!! tu feras mieux la prochaine fois !");
            return true;
        }
        removePossibility(list, list.get(index), 0, goodPlace, present);
        return false;
    }

    public boolean userTurn(char[] secretNumberOfIa) {
        System.out.println("devine la combinaisont secrète : ");
        String userResponse = sc.next();
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
// TODO: 03/04/2019 terminé mastermindDuel
// TODO: 15/04/2019 renplissage list silencieux
// TODO: 15/04/2019 ajouté vie