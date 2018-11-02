package com.resnidar;

public class SearchGame extends Games {
    int[] choice;
    int[] experctedResult;

    void logic(){

        System.out.println("lancement du jeu : nombre secret ");
    }

    void random(){
        RandomGeneration randomGeneration = new RandomGeneration();
        randomGeneration.countnumber();
    }

    void temporaire(){

    }
}
