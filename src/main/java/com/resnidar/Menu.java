package com.resnidar;

import java.util.Scanner;

public class Menu {
    void logic(){
        SearchGame searchGame = new SearchGame();
        System.out.println("Voici la listes des jeux : ");
        System.out.println("taper : 1 pour joué au nombre secret");
        System.out.println("taper : 2 pour joué au Mastermind");
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        if (result == 1) {
            System.out.println("vous avez choisi le jeu du nombre secret");
            searchGame.logic();
        }
        else if (result == 2){
            System.out.println("vous avez choisi le jeu : mastermind");
        }
        else
            System.out.println("il y a surement une erreur ,veuillez recommencé ");
    }
}
