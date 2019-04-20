package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.Games;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class SearchGame extends Games {

    static Logger logger = Logger.getLogger(SearchGame.class);
    private int win;
    protected boolean devMode;
    Scanner sc = new Scanner(System.in);

    SearchGame(Config config) {
        super(config);
        devMode = config.getDevMode();
    }

    /**
     * the base of class, it's the logic.
     *
     * @return if the gameMode restart (1) / game restart with other gameMode (2) / close (3)
     */
    void iaLogic() {
        String userIndic;
        char[] userIndicTab;
        boolean loose;
        this.win = 0;
        char[] userNumberChar = userRequest();
        char[] iaTab = new char[userNumberChar.length];
        for (int i = 0; i < userNumberChar.length; i++)
            iaTab[i] = '5';
        while (this.life > 0 && this.win != userNumberChar.length) { // cette boucle est limité par la vie
            System.out.print("AiA : je te propose ");
            for (char c : iaTab) System.out.print(c);
            System.out.println(" saisie  + , - ou =");
            userIndic = sc.next();
            userIndicTab = userIndic.toCharArray();
            win = 0;
            // ia
            loose = iaMind(userIndicTab, iaTab);
            iaWinOrLose(userNumberChar, loose);
            System.out.print("AiA : il me reste " + life);
            if (life == 1)
                System.out.println(" vie");
            else
                System.out.println(" vies");
        }
    }

    /**
     * it's a part of defence mods
     * this method is the dechotomie of defence game.
     *
     * @param userIndicTab indication of user for ia (+ ,- or =)
     * @param iaTab        le nombre que propose l'ia
     * @return lose        if true : the game is lose
     */
    boolean iaMind(char[] userIndicTab, char[] iaTab) {
        boolean lose = false;
        double temporary; //temporary permet de stocké les chars du tableau iaTab en int
        for (int j = 0; iaTab.length > j; j++) { // cette boucle permet de faire toute les cases du tab
            if (userIndicTab[j] == '+') {
                // ici je met mon char dans temporary ,c'est plus simple de travaillé avec des nombre quant ont fait des math
                // le : - '0' me permet d'enlever 48 au nombre qui est actuellement 53 (table ascii)
                temporary = (double) iaTab[j] - '0';
                if (temporary >= 5)// j'avait un probleme ,c'est qu'il était impossible d'atteindre les 6 ou 4 ,grace a cette ligne ,c'est tout bon
                    temporary += (9);
                if (temporary < 5)
                    temporary += 5;// si iaTab est de 3 ,sa me permet de faire 3+5/2 ,et d'avoir donc 4 }
                temporary /= Math.ceil(2);
                iaTab[j] = (char) Math.ceil(temporary);
                iaTab[j] += '0'; // comme tout a l'heure ,iaTab a x dans la table ascii ,pour avoir un char avec le bon nombre ,il faut ajouter 48
                lose = true;
            } else if (userIndicTab[j] == '-') {
                temporary = (double) iaTab[j] - '0';
                if (temporary > 5)
                    temporary += 5;
                if (temporary == 1)
                    temporary = 0;
                temporary /= 2;
                iaTab[j] = (char) Math.ceil(temporary);
                iaTab[j] += '0';
                lose = true;
            } else if (userIndicTab[j] == '=') {
                this.win += 1;
            } else
                System.out.println("erreur !");
        }
        return lose;
    }

    private void iaWinOrLose(char[] userNumberChar, boolean fail) {
        if (fail)
            this.life -= 1;
        if (this.win == userNumberChar.length && this.life != 0)
            System.out.println("AiA : j'ai gagné ! il me restait " + this.life + " vie :D !");
        if (this.win != userNumberChar.length && this.life > 0)
            System.out.println("il reste " + this.life + " vies ");
        if (this.life < 0)
            System.out.println("AiA : bien jouer ,j' ai perdu ! il ne me reste plus de vie");
    }

    /**
     * cette fonction permet d'interargir avec l'utilisateur
     *
     * @param life            nombre de vie de l'user
     * @param randomNumberTab tableau de nombre aléatoire
     */
    void userInteract(int life, char[] randomNumberTab) {
        String proposition;
        boolean endGame = false;
        char[] userTab;
        int totalFail = 0;
        int fail = 0;
        for (int i = 0; i < life && !endGame; i++) {
            System.out.println("AiA : c'est à toi, essai de trouver le nombre que je te cache");
            SearchGameChallenger.logger.debug("attente de l'user");
            userTab = controlUserNumberScanner();
            SearchGameChallenger.logger.debug("proposition recu");
            //userTab = proposition.toCharArray();
            SearchGameChallenger.logger.debug("String > tableau de char");
            try {
                SearchGameChallenger.logger.debug("propositionCompar : comparaison entrée utilisateur et entrée");
                fail = propositionCompar(randomNumberTab, userTab, fail);
                if (fail == 0)
                    endGame = true;
                if (fail > 0)
                    totalFail++;
                if (fail != userTab.length && fail != 0)
                    System.out.println("\nAiA : bien joué, tu te rapproches du bon résultat");
                if (fail == userTab.length)
                    System.out.println("\n\nAiA : dommage, tu n'y es pas");
                fail = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                SearchGameChallenger.logger.error("method propositionCompar don't work");
                System.out.println("une erreur est survenu ,veuillez rentrer " + randomNumberTab.length + " caracteres");
            }
        }
        if (totalFail < life) {
            System.out.println("\n\rAiA : Mince, j'ai perdu ... bien jouer ! ");
        } else {
            System.out.print("\n\nAiA : Génial j'ai gagné ! tu feras peu être mieux la prochaine fois" +
                    "\nle nombre que je te cachait est le ");
            for (int i = 0; i < randomNumberTab.length; i++) {
                System.out.println(randomNumberTab[i]);
            }
        }
        System.out.println("AiA : la réponse était " + randomGeneration.getWholeNumber());
    }
}

// TODO: 15/01/2019 sécurisé le code pour évité que l user rentre n importe quoi

