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
        for (int i = 0; i < 15; i++)
            System.out.println();
        System.out.println("------------------------------------\n" +
                "AiA : bienvenue sur le mode de jeu challenger du mastermind,\n" +
                "je t'explique les règles : \n" +
                "tu dois trouver mon code secret, je ne t'aiderais qu'avec des indices simples :\n" +
                "combien de chiffres sont présents, combiens sont à la bonne place\n" +
                "pour bien jouer tu as deux règles à connètres :\n" +
                "s'il y a 4 couleurs ,la première est 0. donc il y a les couleurs : 0, 1, 2, 3\n" +
                "s'il y a 4 couleurs a la bonne place, c'est qu'elles sont aussi présentes !");
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
        expected = randomGeneration.getRandomNumber(numberSize, devMode);
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

}
//tester jusqu a 10

//knuth

