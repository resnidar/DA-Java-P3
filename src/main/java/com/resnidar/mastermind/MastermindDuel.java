package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.ArrayList;
import java.util.Scanner;

public class MastermindDuel extends MastermindGame implements GameLogic {
    int numberSize;
    int numberColor;
    public MastermindDuel(Config config) {
        super(config);
        numberSize = config.getNumberSize();
        numberColor = config.getColorNumber();
    }

    @Override
    public boolean logic() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] secretNumberOfIa;
        boolean game = true;
        // TODO: 24/03/2019 prevenir le joueur que la partie commence
        System.out.println("bienvenue dans le mode duel");
        System.out.println("la partie commence :");
        // TODO: 24/03/2019  préparation de la partie (list etc...)
        listPrep(numberColor, numberSize);
        secretNumberOfIa = randomGeneration.getRandomNumber(numberSize, devMode);
        // TODO: 24/03/2019 le joueur propose ,l ia lui répond
        System.out.println("aia : tu commence ! propose moi un nombre : ");
        for (int turn = 0; turn < 10 || !game; turn++) { // TODO: 26/03/2019 nombre de tour !!!
            userTurn(secretNumberOfIa);
            System.out.println("aia : a moi de joué !");
            iaTurn();
        }
        // TODO: 24/03/2019 l ia propose, le joueur lui répond
        // TODO: 24/03/2019 ont recommence jusqu a la victoire ou la defaite
        return false;
    }

    private void iaTurn() {
        int index;
        int goodPlace;
        int present;
        System.out.println("aia : c'est a moi");
        index = proposition();
        System.out.println("donne moi le nombre de nombre a la bonne place");
        goodPlace = sc.nextInt();
        System.out.println("donne moi le nombre de present");
        present = sc.nextInt();
        removePossibility(list, list.get(index), 0, goodPlace, present);
    }

    public boolean userTurn (char[] secretNumberOfIa){
        System.out.println("devine la combinaisont secrète : ");
        String userResponse = sc.next();
        int present;
        int goodPlace;
        present = present(userResponse.toCharArray(), secretNumberOfIa);
        goodPlace = goodPlace(userResponse.toCharArray(), secretNumberOfIa);
        System.out.println("hmmm, il y en a " + present + " de present et " + goodPlace + " a la bonne place");
        if (goodPlace == secretNumberOfIa.length)
            return true;
        return false;
    }
}
// TODO: 26/03/2019 deplacé class test dans leurs propre package ou leurs propres dossiers 