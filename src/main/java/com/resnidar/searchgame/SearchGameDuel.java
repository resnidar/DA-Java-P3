package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.UserRestartChoice;

import java.util.Scanner;

public class SearchGameDuel extends SearchGame implements GameLogic {
    private Scanner sc = new Scanner(System.in);
    private static int staticLife;

    public SearchGameDuel(Config config) {
        super(config);
        staticLife = config.getLife();
    }

    /**
     * the base of class, it's the logic.
     *
     * @return if the gameMode restart (1) / game restart with other gameMode (2) / close (3)
     */
    public UserRestartChoice logic() {
        char[] iaTab = new char[numberSize];
        char[] iaNumberChar;
        char[] userTab;
        int fail;
        boolean loose;
        boolean winGame = false;
        boolean error;
        String proposition;
        UserRestartChoice restartByte;
        for (int i = 0; i < 15; i++)
            System.out.println();
        if (devMode)
            System.out.println("le devMode est activé pour cette partie");
        System.out.println("AiA : pour cette partie, nous n'avons pas de vie, c'est le premier à trouver la combinaison qui gagne \n");
        logger.debug("Mode duel du SearchGame lancé");
        System.out.println("AiA : d'accord" +
                " c'est partie pour le mode duel !");
        System.out.println("------------------------------------\n" +
                "je t'éxplique les règles rapidement:\n" +
                "nous devons chacun notre tour essayé de trouver le numéro caché de l'autre\n" +
                "le premier a trouvé le numéro a gagner, il n'y a pas de point de vie\n" +
                "chaque numéro a une longueur d'exactement " + numberSize + " chiffres\n" +
                "------------------------------------");
        iaNumberChar = randomGeneration.getRandomNumber(numberSize, devMode, 10); // method
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
            //String userIndic = sc.next();
            char[] userIndicTab = controlCharOfUserForOperatorCarac();
            loose = iaMind(userIndicTab, iaTab);
            if (!loose) {
                System.out.println("AiA : haha ! j'ai gagner !");
                System.out.println("mon nombre secret était " + randomGeneration.getWholeNumber());
                winGame = true;
            }
            if (!winGame) {
                System.out.println("AiA : très bien, c'est noté ,a toi de faire une proposition\n" +
                        "je te répondrais avec des indices!");
                System.out.println("fait moi une proposition : ");
                /*proposition est en string, userTab est un array de char contenant le numero
                 *
                 * */
                do {
                    error = false;
                    proposition = sc.next();
                    userTab = proposition.toCharArray();
                    if (userTab.length != numberSize) {
                        error = true;
                        System.err.println("Attention ! le nombre doit avoir une taille de " + numberSize +
                                " et n'avoir que des chiffres");
                    }
                    for (int i = 0; i < userTab.length && !error; i++) {
                        if (userTab[i] < '0' || userTab[i] > '9') {
                            error = true;
                            System.err.println("Attention ! le nombre doit avoir une taille de " + numberSize +
                                    " et n'avoir que des chiffres");
                        }
                    }
                } while (error);
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
        restartByte = checkingUserRestartChoice();
        return restartByte;
    }
}