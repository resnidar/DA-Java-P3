package com.resnidar;

import java.util.Scanner;

public class SearchGame extends Games {

    void logic(){
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        UserTabProcess userTabProcess = new UserTabProcess();
        int life = 5;
        System.out.println("lancement du jeu : nombre secret ");
        char[] randomNumberTab = randomGeneration.getRandomNumber();
        System.out.println("le nombre est composé de " + randomGeneration.getSize() + " caractères");
        interactUser(randomGeneration, sc, userTabProcess, life, randomNumberTab);
    }

    private void interactUser(RandomGeneration randomGeneration, Scanner sc, UserTabProcess userTabProcess, int life, char[] randomNumberTab) {
        String proposition;
        char[] userTab;
        for(int i = 0; i < life ; i++) {
            System.out.println("trouve les bon numero :");
            proposition = sc.next();
            userTabProcess.setUserNbr(proposition);
            userTab = userTabProcess.userTabProcess();
            comparUser(randomGeneration, randomNumberTab, userTab);
        }
    }

    private void comparUser(RandomGeneration randomGeneration, char[] randomNumberTab, char[] userTab) {
        for (int j = 0; j < randomNumberTab.length ; j++) {
            if (randomNumberTab[j] > userTab[j]) {
                System.out.print("+");
            }
            else if(randomNumberTab[j] == userTab[j])
                System.out.print("=");
            else if(randomNumberTab[j] < userTab[j])
                System.out.print("-");
            else
                System.out.println("erreur");
        }
    }
}