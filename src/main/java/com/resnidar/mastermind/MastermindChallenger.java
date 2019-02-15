package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class MastermindChallenger extends MastermindGame implements GameLogic {

    public MastermindChallenger(Config config) {
        super(config);
    }
    int goodPlace = 0;
    int present = 0;

    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        boolean restart = false;
        int restartResponse;
        System.out.println("lancement du jeu Mastermind Challenger");
        iaMindMastermind();
        System.out.println("veut tu recommencer une partie de Mastermind en mode Challenger ? ");
        System.out.println("1 pour oui ou 2 pour non");
        restartResponse = sc.nextInt();
        if (restartResponse == 1)
            restart = true;
        else if (restartResponse == 2)
            restart = false;
        return restart;
    }

    private void iaMindMastermind() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] answer; // sera connecter au properties
        char[] expected = {'6', '0', '6', '0'};
        boolean win = false;
        //expected = randomGeneration.getRandomNumber(numberSize);
        while (life > 0 && !win) {
            System.out.println("veuillez entrer le nombre a testé : ");
            answer = userRequest();
            present = present(answer, expected);
            goodPlace = goodPlace(answer,expected);
            present -= goodPlace;
            System.out.println("il y a " + present + " numero present mais pas a la bonne place ");
            System.out.println("il y a " + goodPlace + " numero a la bonne place");
            if (goodPlace != numberSize) {
                life--;
            } else
                win = true;
            System.out.println("il te reste " + life + " vie");
        }
        if (goodPlace == numberSize && life > 0) {
            System.out.println("bien joué tu a gagné !");
        } else {
            System.out.println("tu est arriver a la fin de tes vies ,tu a perdu");
        }
    }


    public int present(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre qui sont present
        int present = 0;
        int[] stat = new int[expected.length];
        for (int answerIndex = 0; answerIndex < answer.length; answerIndex++){
            for (int expectedIndex = 0; expectedIndex < expected.length; expectedIndex++){
                if (answer[answerIndex] == expected[expectedIndex] && stat[expectedIndex] == 0){
                    present++;
                    stat[expectedIndex] = 1;
                }
            }
        }
        return present;
    }

    public int goodPlace(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre a la bonne place
        int goodPlace = 0;
        for (int answerIndex = 0; answerIndex < answer.length; answerIndex++)
        {
            if (answer[answerIndex] == expected[answerIndex]){
                goodPlace++;
            }
        }
        return goodPlace;
    }

    /*public int[] test(char[] expected, char[] answer){
        int[] stat = new int[numberSize]; // 0 = pas trouver 1 = present 2 = bonne place

        return stat;
    }*/
}
//tester jusqu a 10

//knuth

