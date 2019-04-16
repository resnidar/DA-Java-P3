package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

public class MastermindChallenger extends MastermindGame implements GameLogic {
    public MastermindChallenger(Config config) {
        super(config);
    }


    /**
     * the base of class, it's the logic.
     *
     * @return if the gameMode restart (1) / game restart with other gameMode (2) / close (3)
     */
    public byte logic() {
        byte restartByte;
        for (int i = 0; i < 15; i++)
            System.out.println();
        System.out.println("------------------------------------\n" +
                "AiA : bienvenue sur le mode de jeu challenger du mastermind,\n" +
                "je t'explique les règles : \n" +
                "tu dois trouver mon code secret, je ne t'aiderais qu'avec des indices simples :\n" +
                "combien de chiffres sont présents, combiens sont à la bonne place\n" +
                "pour bien jouer tu as deux règles à connaitres :\n" +
                "s'il y a 4 couleurs ,la première est 0. donc il y a les couleurs : 0, 1, 2, 3\n" +
                "s'il y a 4 couleurs a la bonne place, c'est qu'elles sont aussi présentes !");
        iaMindMastermind();
        restartByte = fonctionRestartChoice();
        return restartByte;
    }

    /**
     * the base of Ia for mastermind challenger
     */
    private void iaMindMastermind() {
        char[] answer; // sera connecter au properties
        char[] expected;
        boolean win = false;
        int goodPlace = 0;
        int present;
        expected = randomGeneration.getRandomNumber(numberSize, devMode, numberSize);
        while (life > 0 && !win) {
            System.out.println("veuillez entrer le nombre a testé : ");
            answer = userRequest();
            present = present(answer, expected);
            goodPlace = goodPlace(answer, expected);
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
            System.out.println("la combinaison secrète était " + randomGeneration.getWholeNumber());
        }
    }

}