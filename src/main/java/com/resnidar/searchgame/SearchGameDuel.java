package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class SearchGameDuel extends SearchGame implements GameLogic {

    RandomGeneration rg = new RandomGeneration();
    Scanner sc = new Scanner(System.in);
    static int staticLife;

    boolean devMode;
    public SearchGameDuel(Config config) {
        super(config);
        //staticLife = life;
    }

    public boolean logic() {
        System.out.println("challenger est sur : " + devMode);
        System.out.println("life = " + life + "\nnumberSize " + numberSize);
        System.out.println("duel est sur : " + devMode);
        char[] iaTab = new char[numberSize];
        char[] iaNumberChar;
        char[] userTab;
        int fail = 0;
        boolean lose = false;
        boolean winGame = false;
        boolean restart = false;
        char restartChar;
        String proposition;
        logger.debug("Mode duel du SearchGme lancé");
        System.out.println("AiA : d'accord" +
                " c'est partie pour le mode duel !");
        System.out.println("entre le numero que je doit trouver : ");
        System.out.println("AiA : Attention ,il faut mettre un nombre de : " + numberSize + " exactement");
        System.out.println("tu peut changer sa dans le .properties");
        iaNumberChar = rg.getRandomNumber(numberSize, devMode); // method
        while (winGame == false) {
            fail = 0;
            if (this.life == staticLife) {
                System.out.println("AiA : allez ! c'est a moi de deviné ton nombre ,est ce que c'est : ");
                for (int j = 0; j < iaTab.length; j++) {
                    iaTab[j] = '5';
                    System.out.print(iaTab[j]);
                }
            } else {
                System.out.println("AiA : moi je te propose : ");
                for (int j = 0; j < iaTab.length; j++)
                    System.out.print(iaTab[j]);
            }
            System.out.println("\nAiA : répond moi avec +, - ou =");
            String userIndic = sc.next();
            char[] userIndicTab = userIndic.toCharArray();
            lose = iaMind(userIndicTab, iaTab);
            if (lose == false) {
                System.out.println("AiA : haha ! j'ai gagner !");
                winGame = true;
            }
            if (winGame == false) {
                System.out.println("très bien c'est noté ,a toi !");
                System.out.println("fait moi une proposition : ");
                proposition = sc.next();
                userTab = proposition.toCharArray();
                fail = propositionCompar(iaNumberChar, userTab, fail); // method
                if (fail == 0) {
                    System.out.println("\nAiA : bien jouer ,tu m'a battue ... ");
                    winGame = true;
                }
                if (fail != 0 && fail != proposition.length() - 1 && fail != 1)
                    System.out.println("\nAiA : ce n'est pas ca");
                if (fail == proposition.length() - 1)
                    System.out.println("\nAiA : bien jouer sa progresse ! ");
                if (fail == 1)
                    System.out.println("\nAiA : tu y est presque ! plus qu'un a trouver");
                if (fail != 0) {
                    System.out.println("AiA : et non tu t'es tromper");
                    this.life--;
                }
            }
        }
        System.out.println("voulez vous recommencer ?");
        System.out.println("oui : y \n non : n");
        restartChar = sc.next().charAt(0);
        if (restartChar == 'y')
            restart = true;
        else if (restartChar == 'n')
            restart = false;
        else
            System.out.println("il y a une erreur ,il fallait rentré y ou n");
        return restart;
    }
    // TODO: 15/01/2019 sécurisé le code pour évité que l user rentre n importe quoi
    // TODO: 15/01/2019 faire la documentation
    // TODO: 22/01/2019 sonar > a telecharger (ou utiliser)
    // TODO: 22/01/2019 trevis (se renseigner)
}
