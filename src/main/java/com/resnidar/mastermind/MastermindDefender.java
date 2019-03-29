package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MastermindDefender extends MastermindGame implements GameLogic {
    int numberOfColor;
    public MastermindDefender(Config config) {
        super(config);
        numberOfColor = config.getColorNumber();
    }

    @Override
    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        int present;
        int goodPlace;
        int numberOfTurns = 0;
        boolean win = false;
        int restart;
        int indexToListForDelete;
        listPrep(numberOfColor, numberSize);
        System.out.println("la liste est remplie ,le jeu commence");
        while (!win) {
            indexToListForDelete = proposition();
            goodPlace = sc.nextInt();
            System.out.println("combien y en a t il de present ?");
            present = sc.nextInt();
            System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
                list = removePossibility(list, list.get(indexToListForDelete),numberOfTurns , goodPlace, present);
             if (goodPlace == numberSize) {
                win = true;
                System.out.println("tu a gagné bien joué ! veut tu recommencer ?");
                System.out.println("0 pour oui  \n1 pour non");
                restart = sc.nextInt();
                if (restart == 0)
                    return true;
                else if (restart == 1)
                    return false;
            }
            numberOfTurns++;
        }
        return false;
    }


}

// TODO: 19/02/2019 avertir utilisateur des limites
// TODO: 19/03/2019 logger 