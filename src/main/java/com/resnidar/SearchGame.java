package com.resnidar;

public class SearchGame extends Games {
    int[] choice;
    int[] experctedResult;

    void logic(){

        System.out.println("lancement du jeu : nombre secret ");
        this.random();
    }

    void random(){
        RandomGeneration randomGeneration = new RandomGeneration();
        randomGeneration.countnumber();
        System.out.println("voila le nombre aleatoire choisi class : SearchGame" + randomGeneration.countnumber());
    }

    void temporaire(){

    }
}
