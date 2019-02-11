package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

public class MastermindChallenger extends MastermindGame implements GameLogic {

    public MastermindChallenger(Config config) {
        super(config);
    }

    public boolean logic(){
        boolean restart = false;
        System.out.println("lancement du jeu Mastermind Challenger");
        iaMindMastermind();
        return restart;
    }

    void iaMindMastermind(){
        RandomGeneration randomGeneration = new RandomGeneration();
        char[][] answer = new char[1][numberSize]; // sera connecter au properties
        char[] expected;
        char[] userRequest;
        boolean next = false;
        int goodPlace = 0;
        int present = 0;
        expected = randomGeneration.getRandomNumber(numberSize);
        System.out.println("entre les nombres que tu veut tester : ");
        userRequest = userRequest();
        for (int i = 0; i < userRequest.length; i++) {
            answer[0][i] = userRequest[i];// permet de mettre userRequest dans mon tableau bidimensionnel
        }
        for (int i = 0; i < numberSize ; i++){// permet de faire tout le tableau i = 0
            // i = answer
            // j = expected
            next = false;
            for (int j = 0; j < numberSize && i < 4 && !next; j++){
                if (answer[0][i] == expected[i]) {  // oui
                    goodPlace++;
                    next = true;
                }
                else if (answer[0][i] == expected[j]){ // si je tombe sur le bon numero mais pas a la bonne place alors :
                    present++; // ajoute 1 a present
                    next = true;
                }
            }
        }

        System.out.println("il y a " + present + " numero present mais pas a la bonne place ");
        System.out.println("il y a " + goodPlace + " numero a la bonne place");
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