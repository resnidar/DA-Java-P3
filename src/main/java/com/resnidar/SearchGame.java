package com.resnidar;

import java.util.Scanner;

public class SearchGame extends Games {

    void logic(){
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        UserTabProcess userTabProcess = new UserTabProcess();
        int proposition;
        int life = 5;
        int[] userTab;
        System.out.println("lancement du jeu : nombre secret ");
        int[] randomNumberTab = randomGeneration.getRandomNumber();
        System.out.println("le nombre est composé de " + randomGeneration.getSize() + " caractères");
        interactUser(randomGeneration, sc, userTabProcess, life, randomNumberTab);
    }

    private void interactUser(RandomGeneration randomGeneration, Scanner sc, UserTabProcess userTabProcess, int life, int[] randomNumberTab) {
        int proposition;
        int[] userTab;
        for(int i = 0; i < life ; i++) {
            System.out.println("trouve les bon numero :");
            proposition = sc.nextInt();
            userTabProcess.setNbr(proposition);
            userTab = userTabProcess.userTabProcess();
            comparUser(randomGeneration, randomNumberTab, userTab);
        }
    }

    private void comparUser(RandomGeneration randomGeneration, int[] randomNumberTab, int[] userTab) {
        for (int j = 0; j < randomGeneration.getSize() ; j++) {
            if (randomNumberTab[j] > userTab[j])
                System.out.print("+");
            else if(randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if(randomNumberTab[j] < userTab[j])
                System.out.print("-");
            else
                System.out.println("erreur");
        }
    }
}