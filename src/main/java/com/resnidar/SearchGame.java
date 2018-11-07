package com.resnidar;

import java.util.Scanner;

public class SearchGame extends Games {

    void logic(){
        RandomGeneration randomGeneration = new RandomGeneration();
        Scanner sc = new Scanner(System.in);
        UserTabProcess userTabProcess = new UserTabProcess();
        int proposition;
        int life = 5;
        int[] userTab = new int[randomGeneration.getSize()];
        System.out.println("lancement du jeu : nombre secret ");
        int[] randomNumber = randomGeneration.getRandomNumber();
        //todo: faire saisir nombre a l'utilisateur stocker dans tab
        System.out.println("le nombre est composé de " + randomGeneration.getSize() + " caractères");
        for(int i = 0; i < life ;i++) {
            System.out.println("trouve les bon numero :");
            proposition = sc.nextInt();
            userTabProcess.setNbr(proposition);
            userTab = userTabProcess.userTabProcess();
            //todo: comparer les tableau ----------------------------
            for (int j = 0; ; j++) {

            }
            //todo: fin de comparaison ------------------------------
        }
        //todo: afficher case par case le resultat
    }
}