package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.RandomGeneration;

public class SearchGameDuel extends SearchGame{

    int numberSize;

    public SearchGameDuel(Config config) {
        super(config);
        numberSize = config.getNumberSize();
    }
    RandomGeneration rg = new RandomGeneration();



    void logic (){
        char[] userNumberChar;
        logger.debug("Mode duel du SearchGme lancé");
        System.out.println("AiA : d'accord c'est partie pour le mode duel !");
        System.out.println("entre le numero que je doit trouver : ");
        // TODO: 15/01/2019 demander a l utilisateur le numero contre l ia
        userNumberChar = userRequest();
        // TODO: 15/01/2019 l ia genere le numero contre l user
        userNumberChar = rg.getRandomNumber(numberSize);
        // TODO: 15/01/2019 l user propose
        System.out.println("AiA : je commence !");
        // TODO: 15/01/2019 l ia donne des signes a luser
    }




    // TODO: 15/01/2019 l ia propose
    // TODO: 15/01/2019 l user donne des signes a l ia
    // TODO: 15/01/2019 a chaque tour ,ils voyent la vie restante ,les proposition precedente et les signes proposé
    // TODO: 15/01/2019 le premier a trouver le nombre est déclaré vainqueurs
    // TODO: 15/01/2019 proposition : voulez vous recommencer
    // TODO: 15/01/2019 sécurisé le code pour évité que l user rentre n importe quoi
    // TODO: 15/01/2019 faire la documentation
}
