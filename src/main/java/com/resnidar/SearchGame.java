package com.resnidar;

import java.util.Scanner;

public class SearchGame extends Games {

    char logic(){
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        char restart;
        int life = 5;
        System.out.println("lancement du jeu : nombre secret ");
        char[] randomNumberTab = randomGeneration.getRandomNumber();
        System.out.println("le nombre est composé de " + randomGeneration.getSize() + " caractères");
        interactUser(sc, life, randomNumberTab);
        System.out.println("voulez vous rejouer ? ");
        restart = sc.next().charAt(0);
        return restart;
    }

    private void interactUser(Scanner sc, int life, char[] randomNumberTab) {
        String proposition;
        boolean endGame = false;
        char[] userTab;
        int totalFail = 0;
        int fail = 0;
        for(int i = 0; i < life && endGame == false; i++) {
            System.out.println("trouve les bon numero :");
            proposition = sc.next();
            userTab = UserTabProcess.userTabProcess(proposition);
            proposition.toCharArray();
            fail = propositionCompar(randomNumberTab, userTab, fail, endGame);
            if (fail == 0)
                endGame = true;
            if (fail > 0)
                totalFail++;
            fail = 0;
        }
        if (totalFail < life){
            System.out.println("\n\rbien joué ,tu a gagné");
            endGame = true;
        }
        else
            System.out.println("tu a perdu desole");
    }

    private int propositionCompar(char[] randomNumberTab, char[] userTab, int fail, boolean endGame) {
        for (int j = 0; j < randomNumberTab.length; j++) {
            if (randomNumberTab[j] > userTab[j]) {
                System.out.print("+");
                fail++;
            } else if (randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if (randomNumberTab[j] < userTab[j]) {
                System.out.print("-");
                fail++;
            } else
                System.out.println("erreur");
        }
        return fail;
    }
}