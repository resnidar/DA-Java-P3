package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.RandomGeneration;

import java.util.Scanner;

public class SearchGameDuel extends SearchGame implements GameLogic {

    private RandomGeneration rg = new RandomGeneration();
    private Scanner sc = new Scanner(System.in);
    private static int staticLife;

    public SearchGameDuel(Config config) {
        super(config);
        staticLife = config.getLife();
    }

    public byte logic() {
        char[] iaTab = new char[numberSize];
        char[] iaNumberChar;
        char[] userTab;
        int fail;
        boolean lose;
        boolean winGame = false;
        boolean restart = false;
        byte restartByte;
        for (int i = 0; i < 15; i++)
            System.out.println();
        if (devMode)
            System.out.println("le devMode est activé pour cette partie");
        System.out.println("AiA : pour cette partie, tu as " + life + " vies, tu peux changer ça dans le config.properties \n");
        String proposition;
        logger.debug("Mode duel du SearchGme lancé");
        System.out.println("AiA : d'accord" +
                " c'est partie pour le mode duel !");
        System.out.println("------------------------------------\n" +
                "je t'éxplique les règles rapidement:\n" +
                "nous devons chacun notre tour essayé de trouver le numéro caché de l'autre\n" +
                "le premier a trouvé le numéro a gagner, il n'y a pas de point de vie\n" +
                "chaque numéro a une longueur d'exactement " + numberSize + " chiffres\n" +
                "------------------------------------");
        iaNumberChar = rg.getRandomNumber(numberSize, devMode); // method
        while (!winGame) {
            fail = 0;
            if (this.life == staticLife) {
                System.out.println("AiA : allez ! c'est à moi de deviner ton nombre, est ce que c'est : ");
                for (int j = 0; j < iaTab.length; j++) {
                    iaTab[j] = '5';
                    System.out.print(iaTab[j]);
                }
            } else {
                System.out.println("AiA : je te propose : ");
                for (char c : iaTab) System.out.print(c);
            }
            System.out.println("\nAiA : répond moi avec +, - ou =");
            String userIndic = sc.next();
            char[] userIndicTab = userIndic.toCharArray();
            lose = iaMind(userIndicTab, iaTab);
            if (!lose) {
                System.out.println("AiA : haha ! j'ai gagner !");
                winGame = true;
            }
            if (!winGame) {
                System.out.println("AiA : très bien, c'est noté ,a toi de faire une proposition\n" +
                        "je te répondrais avec des indices!");
                System.out.println("fait moi une proposition : ");
                proposition = sc.next();
                userTab = proposition.toCharArray();
                fail = propositionCompar(iaNumberChar, userTab, fail); // method
                if (fail == 0) {
                    System.out.println("\nAiA : Mince tu m'as battue !  Bien joué");
                    winGame = true;
                }
                if (fail != 0 && fail != proposition.length() - 1 && fail != 1)
                    System.out.println("\nAiA : ce n'est pas ça");
                if (fail == proposition.length() - 1)
                    System.out.println("\nAiA : bien jouer sa progresse ! ");
                if (fail == 1)
                    System.out.println("\nAiA : tu y es presque ! plus qu'un a trouvé");
                if (fail != 0) {
                    System.out.println("AiA : tu t'es trompé");
                    this.life--;
                }
            }
        }
        restartByte = fonctionRestartChoice();
        return restartByte;
    }

    // TODO: 15/01/2019 sécurisé le code pour évité que l user rentre n importe quoi
    // TODO: 15/01/2019 faire la documentation
}
