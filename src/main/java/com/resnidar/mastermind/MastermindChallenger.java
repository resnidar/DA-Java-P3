package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class MastermindChallenger extends MastermindGame implements GameLogic {
    public MastermindChallenger(Config config) {
        super(config);
    }


    /**
     * method logic : is the logic of this Class
     * @return restart : if is true ,the game restart
     */
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
        return restart;
    }

    /**
     * the base of Ia for mastermind challenger
     */
    private void iaMindMastermind() {
        RandomGeneration randomGeneration = new RandomGeneration();
        char[] answer; // sera connecter au properties
        char[] expected;
        boolean win = false;
        int goodPlace = 0;
        int present;
        expected = randomGeneration.getRandomNumber(numberSize);
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

    /**
     *
     * @param answer an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return present : the number of present number
     */
    int present(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre qui sont present
        int present = 0;
        int[] stat = new int[expected.length];
        for (char c : answer) {
            for (int expectedIndex = 0; expectedIndex < expected.length; expectedIndex++) {
                if (c == expected[expectedIndex] && stat[expectedIndex] == 0) {
                    present++;
                    stat[expectedIndex] = 1;
                    break;
                }
            }
        }
        return present;
    }

    /**
     *
     * @param answer an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return goodPlace : the number of number at goodPlace
     */
    int goodPlace(char[] answer, char[] expected){ // ici nous allons calculé le nombre de nombre a la bonne place
        int goodPlace = 0;
        for (int answerIndex = 0; answerIndex < answer.length; answerIndex++)
        {
            if (answer[answerIndex] == expected[answerIndex]){
                goodPlace++;
            }
        }
        return goodPlace;
    }

}
//tester jusqu a 10

//knuth

