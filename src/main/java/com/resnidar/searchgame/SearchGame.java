package com.resnidar.searchgame;

import com.resnidar.Games;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class SearchGame extends Games {

    static Logger logger = Logger.getLogger(SearchGame.class);
    int staticLife;
    int win;
    Scanner sc = new Scanner(System.in);

    public SearchGame() {
        super();
        staticLife = life;
    }


    public void iaLogic() {
        String userIndic;
        char[] userIndicTab;
        boolean loose;
        this.win = 0;
        /*this.life = config.getLife();*/
        char[] userNumberChar = userRequest();
        char[] iaTab = new char[userNumberChar.length];
        for (int i = 0; i < userNumberChar.length; i++)
            iaTab[i] = '5';
        while (this.life > 0 && this.win != userNumberChar.length) { // cette boucle est limité par la vie
            System.out.print("AiA : je te propose ");
            for (int j = 0; j < iaTab.length; j++)
                System.out.print(iaTab[j]);
            System.out.println(" saisie  + , - ou =");
            userIndic = sc.next();
            userIndicTab = userIndic.toCharArray();
            win = 0;
            // ia
            loose = iaMind(userIndicTab, iaTab);
            iaWinOrLose(userNumberChar, loose);
        }
    }

    /**
     * it's a part of defence mods
     * this method is the dechotomie of defence game.
     *
     * @param userIndicTab indication of user for ia (+ ,- or =)
     * @param iaTab        le nombre que propose l'ia
     * @return
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
                    temporary += 5;// si iaTab est de 3 ,sa me permet de faire 3+5/2 ,et d'avoir donc 4
                temporary /= Math.ceil(2);
                iaTab[j] = (char) Math.ceil(temporary);
                iaTab[j] += '0'; // comme tout a l'heure ,iaTab a x dans la table ascii ,pour avoir un char avec le bon nombre ,il faut ajouter 48
                lose = true;
            } else if (userIndicTab[j] == '-') {
                temporary = (double) iaTab[j] - '0';
                if (temporary > 5)
                    temporary += 5;
                temporary /= 2;
                iaTab[j] = (char) Math.floor(temporary);
                iaTab[j] += '0';
                lose = true;
            } else if (userIndicTab[j] == '=') {
                this.win += 1;
            } else
                System.out.println("erreur !");
        }

        return lose;
    }

    public void iaWinOrLose(char[] userNumberChar, boolean fail) {
        if (fail == true)
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
        for (int i = 0; i < life && endGame == false; i++) {
            System.out.println("trouve les bon numero :");
            SearchGameChallenger.logger.debug("attente de l'user");
            proposition = sc.next();
            SearchGameChallenger.logger.debug("proposition recu");
            userTab = proposition.toCharArray();
            SearchGameChallenger.logger.debug("String > tableau de char");
            try {
                SearchGameChallenger.logger.debug("propositionCompar : comparaison entrée utilisateur et entrée");
                fail = propositionCompar(randomNumberTab, userTab, fail);
                if (fail == 0)
                    endGame = true;
                if (fail > 0)
                    totalFail++;
                fail = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
                SearchGameChallenger.logger.error("method propositionCompar don't work");
                System.out.println("une erreur est survenu ,veuillez rentrer " + randomNumberTab.length + " caracteres");
            }
        }
        if (totalFail < life) {
            System.out.println("\n\rbien joué ,tu a gagné");
        } else
            System.out.println("tu a perdu désolé");
    }
}
// TODO: 15/01/2019 faire une class abstraite 
// TODO: 15/01/2019 faire une method abstraite
// TODO: 15/01/2019 faire une interface 
// TODO: 15/01/2019 faire un enum 
// TODO: 15/01/2019 mastermind : les collections ARRAYLIST 
// TODO: 15/01/2019 utiliser une bibliothèque
// TODO: 22/01/2019 mettre en place mode dev via menu
// TODO: 22/01/2019 arraylist hmap etc. collection java