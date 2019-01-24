package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.Games;
import org.apache.log4j.Logger;

import java.util.Scanner;

public abstract class SearchGame extends Games {

    Config config = new Config();
    static Logger logger = Logger.getLogger(SearchGame.class);
    int life;
    static int staticLife;
    static int win;
    int[] a = new int [config.getNumberSize()];
    Scanner sc = new Scanner(System.in);

    public SearchGame(Config config) {
        super(config);
        this.life = config.getLife();
        staticLife = life;
    }



    public void iaLogic() {
        Config config = new Config();
        String userIndic;
        char[] userIndicTab;
        boolean loose;
        this.win = 0;
        this.life = config.getLife();
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
     *it's a parti of defence mods
     * @param userIndicTab indication of user for ia (+ ,- or =)
     * @param iaTab le nombre que propose l'ia
     * @return
     */
    boolean iaMind(char[] userIndicTab ,char[] iaTab) {
        boolean lose = false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0)
            a[i] = 5;
        }
        for (int j = 0; iaTab.length > j; j++) { // cette boucle permet de faire toute les cases du tab
            if(this.a[j] != 1)
            this.a[j] = this.a[j] / 2;
           if (userIndicTab[j] == '+')
           {
               iaTab[j] += (char) Math.ceil(this.a[j]);
               lose = true;
           }
           else if (userIndicTab[j] == '-') {
               iaTab[j] -= (char) Math.floor(this.a[j]);
               lose = true;
           }
           else if (userIndicTab[j] == '='){
               this.win += 1;
           }
           else
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
            System.out.println("il reste " + this.life + " vies " );
        if (this.life < 0)
            System.out.println("AiA : bien jouer ,j' ai perdu ! il ne me reste plus de vie");
    }

    /**
     * this method request an entry at user in a String and pass String in Char Board
     * @return
     */
    char[] userRequest() {
        String userNumber;
        char[] userNumberChar;
        userNumber = sc.next();
        userNumberChar = userNumber.toCharArray();//mise du string dans un tableau de char
        logger.debug("l user a entrée : " + userNumber);
        return userNumberChar;
    }

    /**
     * cette fonction permet d'interargir avec l'utilisateur
     * @param life nombre de vie de l'user
     * @param randomNumberTab tableau de nombre aléatoire
     */
    void userInteract(int life, char[] randomNumberTab) {
        String proposition;
        boolean endGame = false;
        char[] userTab;
        int totalFail = 0;
        int fail = 0;
        for(int i = 0; i < life && endGame == false; i++) {
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
            }catch (ArrayIndexOutOfBoundsException e){
                SearchGameChallenger.logger.error("method propositionCompar don't work");
                System.out.println("une erreur est survenu ,veuillez rentrer " + randomNumberTab.length + " caracteres");
            }
        }
        if (totalFail < life){
            System.out.println("\n\rbien joué ,tu a gagné");
            endGame = true;
        }
        else
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