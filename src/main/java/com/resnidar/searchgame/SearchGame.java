package com.resnidar.searchgame;

import com.resnidar.Config;
import com.resnidar.Games;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class SearchGame extends Games {

    static Logger logger = Logger.getLogger(SearchGame.class);
    int life;
    Scanner sc = new Scanner(System.in);

    public SearchGame(Config config) {
        super(config);
        life = config.getLife();
    }

    /**
     *is the combinaison of if / else and for while for make ia smart
     * @param win if user give an = ,is équals of 1 win.4 numbers and 4 wins said all user entry is '='
     */
    void iaLogic(int win) {
        //preparation ,ont appel
        Config config = new Config();
        String userProp;
        char[] userPropTab;
        boolean fail;
        //boucle vie
        iaMind(/*userNumberChar,*/ win, config);
    }

    public void iaMind(int win, Config config) {
        String userProp;
        char[] userPropTab;
        boolean fail;
        char[] userNumberChar = userRequest();
        char[] iaTab = new char[userNumberChar.length];
        for (int i = 0; i < userNumberChar.length; i++)
            iaTab[i] = '5';
        while (life > 0 && win != userNumberChar.length) { // cette boucle est limité par la vie
            System.out.print("AiA : je te propose ");
            for (int j = 0; j < iaTab.length; j++)
                System.out.print(iaTab[j]);
            System.out.println(" saisie  + , - ou =");
            userProp = sc.next();
            userPropTab = userProp.toCharArray();
            fail = false;
            win = 0;
            // ia
            for (int j = 0; userNumberChar.length > j; j++) { // cette boucle permet de faire toute les cases du tab
                if (config.getLife() == life) {
                    if (userPropTab[j] == '+') {
                        iaTab[j] += 2;
                        fail = true;
                    } else if (userPropTab[j] == '-') {
                        iaTab[j] -= 2;
                        fail = true;
                    } else if (userPropTab[j] == '=')
                        win += 1;
                    else
                        System.out.println(" il doit y avoir une erreur");
                }
                else if (config.getLife() != life){
                if (userPropTab[j] == '+') {
                    iaTab[j] += 1;
                    fail = true;
                } else if (userPropTab[j] == '-') {
                    iaTab[j] -= 1;
                    fail = true;
                } else if (userPropTab[j] == '=')
                    win += 1;
                else
                    System.out.println(" il doit y avoir une erreur");
            }
            else {
                    System.out.println("erreur");
                }
            // fin
            }
            iaWinOrLose(userNumberChar, win, fail);
        }
    }

    public void iaWinOrLose(char[] userNumberChar, int win, boolean fail) {
        if (fail == true)
            life -= 1;
        if (win == userNumberChar.length)
            System.out.println("AiA : j'ai gagné !");
        if (win != userNumberChar.length)
            System.out.println("il reste " + life + " vies " );
        else
            System.out.println("AiA : il me restait " + life + " vies ... j'ai gagner ;) ");
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
// TODO: 15/01/2019 bibli 