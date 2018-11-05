package com.resnidar;

public class SearchGame extends Games {
    //int[] choice;
    //int[] experctedResult;

    void logic(){

        System.out.println("lancement du jeu : nombre secret ");
        this.random();
    }

    private void random(){
        RandomGeneration randomGeneration = new RandomGeneration();
        randomGeneration.countNumber();
        System.out.println("voila le nombre aleatoire choisi class : SearchGame" + randomGeneration.countNumber());
    }

    void temporaire(){

    }
}
