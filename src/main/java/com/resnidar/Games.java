package com.resnidar;

import java.util.Scanner;

public class Games {
    int life;
    int[] randomNumber = new int[3];


    void logic(){
        System.out.println("Voici la listes des jeux : ");
        System.out.println("taper : 1 pour joué au nombre secret");
        System.out.println("taper : 2 pour joué au Mastermind");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        RandomGeneration randomGeneration = new RandomGeneration();
        if (result == 1) {
            System.out.println("vous avez choisi le jeu du nombre secret");
            randomNumber = randomGeneration.countNumber();
            for(int i = 0;i < randomNumber.length ;i++){
                System.out.println(randomNumber[i]);
            }
        }
        else if (result == 2){
            System.out.println("vous avez choisi le jeu : mastermind");
        }
        else
            System.out.println("il y a surement une erreur ,veuillez recommencé ");
    }
}