package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class MastermindChallenger extends MastermindGame implements GameLogic {
    public MastermindChallenger() {
        super();
    }

    public boolean logic(){
        boolean restart = false;
        System.out.println("lancement du jeu Mastermind Challenger");
        iaMindMastermind();
        return restart;
    }

    void iaMindMastermind(){
        RandomGeneration randomGeneration = new RandomGeneration();
        char[][] answer = new char[1][3]; // sera connecter au properties
        char[] expected;
        char[] userRequest;
        int goodPlace = 0;
        int present = 0;
        int life = 5;
        expected = randomGeneration.getRandomNumber(4);
        System.out.println("le nombre a trouver est ");
        for (int i = 0; i < expected.length; i++)
            System.out.println(expected[i]);
        System.out.println("entre les nombres que tu veut tester : ");
        userRequest = userRequest();
        for (int i = 0; i < userRequest.length - 1; i++)
            answer[0][i] = userRequest[i]; // permet de mettre userRequest dans mon tableau bidimensionnel
            for (int i = 0; i <= answer.length ; i++){// permet de faire tout le tableau
                System.out.println("expected = " + expected[0]);
                System.out.println("answer = " + answer[0][i]);
                if (expected[0] == answer[0][i]) {
                    present++;
                }
                System.out.println("la boucle a faite : " + i + " tours ");
            }

        System.out.println("il y a " + present + " numero present mais pas a la bonne place ");
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