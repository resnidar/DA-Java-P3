package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class MastermindChallenger extends MastermindGame implements GameLogic {

    public MastermindChallenger(Config config) {
        super(config);
    }

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
        char[] expected = {'5','8','3','0'};
        int[] stat = new int[numberSize]; // 0 = pas trouver 1 = present 2 = bonne place
        boolean next;
        boolean win = false;
        int goodPlace = 0;
        int present;
        //expected = randomGeneration.getRandomNumber(numberSize);
        while (life > 0 && !win) {
            for (int i = 0; i < stat.length; i++){
                stat[i] =0;
            }
            System.out.println("entre les nombres que tu veut tester : ");
            answer = userRequest();
            present = 0;
            goodPlace = 0;
            for (int i = 0; i < numberSize; i++) {// permet de faire tout le tableau i = 0
                // i = answer
                // j = expected
                next = false;
                for (int j = 0; j < numberSize && i < 4 && !next; j++) {
                    if (answer[i] == expected[j] && stat[i] == 0) { // si je tombe sur le bon numero mais pas a la bonne place alors :
                        present++; // ajoute 1 a present
                        next = true;
                        stat[i] = 1;
                    }
                    if (answer[i] == expected[i]) {
                        goodPlace++;
                    }
                }
            }
            present -= goodPlace;
            if (present < 0)
                present -= -present;
            System.out.println("il y a " + present + " numero present mais pas a la bonne place ");
            System.out.println("il y a " + goodPlace + " numero a la bonne place");
            if (goodPlace != numberSize) {
                life--;
            }
            else
                win = true;
            System.out.println("il te reste " + life + " vie");
        }
        if (goodPlace == numberSize && life > 0) {
            System.out.println("bien joué tu a gagné !");
        } else {
            System.out.println("tu est arriver a la fin de tes vies ,tu a perdu");
        }


    }
}

/*Set i = 1
    Play fixed initial guess G1
        Get the response X1 and Y1
        Repeat while Xi ≠ P:
        Increment i
        Set Ei = ∅ and h = 1
        Initialize population
        Repeat while h ≤ maxgen and |Ei| ≤ maxsize:
        Generate new population using crossover, mutation, inversion and permutation
        Calculate fitness
        Add eligible combinations to Ei
        Increment h
        Play guess Gi which belongs to Ei
        Get response Xi and Yi
*/

//tester jusqu a 10

//knuth