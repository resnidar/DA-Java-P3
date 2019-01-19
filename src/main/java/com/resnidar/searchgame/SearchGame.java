package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.Games;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGame extends Games {

    static Logger logger = Logger.getLogger(SearchGame.class);
    int life;
    static int win;
    Scanner sc = new Scanner(System.in);

    public SearchGame(Config config) {
        super(config);
        this.life = config.getLife();
    }


    public void iaLogic() {
        Config config = new Config();
        String userProp;
        char[] userPropTab;
        boolean fail;
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
            userProp = sc.next();
            userPropTab = userProp.toCharArray();
            fail = false;
            win = 0;
            // ia
            fail = iaMind(config, userPropTab, fail, userNumberChar, iaTab);
            iaWinOrLose(userNumberChar, fail);
        }
    }

    private boolean iaMind(Config config, char[] userPropTab, boolean fail, char[] userNumberChar, char[] iaTab) {
        for (int j = 0; userNumberChar.length > j; j++) { // cette boucle permet de faire toute les cases du tab
            if (config.getLife() == this.life) {
                if (userPropTab[j] == '+') {
                    iaTab[j] += 2;
                    fail = true;
                } else if (userPropTab[j] == '-') {
                    iaTab[j] -= 2;
                    fail = true;
                } else if (userPropTab[j] == '=')
                    this.win += 1;
                else
                    System.out.println(" il doit y avoir une erreur");
            }
            else if (config.getLife() != this.life){
            if (userPropTab[j] == '+') {
                iaTab[j] += 1;
                fail = true;
            } else if (userPropTab[j] == '-') {
                iaTab[j] -= 1;
                fail = true;
            } else if (userPropTab[j] == '=')
                this.win += 1;
            else
                System.out.println(" il doit y avoir une erreur");
        }
        else {
                System.out.println("erreur");
            }
        // fin
        }
        return fail;
    }

    public void iaWinOrLose(char[] userNumberChar, boolean fail) {
        if (fail == true)
            this.life -= 1;
        if (this.win == userNumberChar.length && this.life != 0)
            System.out.println("AiA : j'ai gagné ! il me restait " + this.life + " vie :D !");
        if (this.win != userNumberChar.length && this.life != 0)
            System.out.println("il reste " + this.life + " vies " );
        if (this.life == 0)
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
        for (int i = 0; userNumberChar.length > i; i++) {
            System.out.println("chiffre " + i + " : " + userNumberChar[i]);
        }
        return userNumberChar;
    }
}

// TODO: 15/01/2019 faire une class abstraite 
// TODO: 15/01/2019 faire une method abstraite
// TODO: 15/01/2019 faire une interface 
// TODO: 15/01/2019 faire un enum 
// TODO: 15/01/2019 mastermind : les collections ARRAYLIST 
// TODO: 15/01/2019 utiliser une bibliothèque