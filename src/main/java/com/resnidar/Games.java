package com.resnidar;

import java.util.Scanner;

class Games {

    void logic(){
        System.out.println("Voici la listes des jeux : ");
        System.out.println("taper : 1 pour joué au nombre secret");
        System.out.println("taper : 2 pour joué au Mastermind");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        if (result == 1) {
            System.out.println("vous avez choisi le jeu du nombre secret");
            randomNumberVerif();
        }
        else if (result == 2){
            System.out.println("vous avez choisi le jeu : mastermind");
        }
        else
            System.out.println("il y a surement une erreur ,veuillez recommencé ");
    }


    /**
     * a temporary method for see if randomNumber working properly
     */
    private void randomNumberVerif() {
        RandomGeneration randomGeneration = new RandomGeneration();
        int[] randomNumber = new int[randomGeneration.getSize()];
        randomNumber = randomGeneration.countNumber();
        for(int i = 0;i < randomNumber.length ;i++){
            System.out.print(randomNumber[i]);
        }
    }
}