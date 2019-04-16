package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.Games;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class MastermindGame extends Games implements GameLogic {
    ArrayList<String> list = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    MastermindGame(Config config) {
        super(config);
    }

    public byte logic() {
        return 3;
    }

    /**
     * @param answer   an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return present : the number of present number
     */
    int present(char[] answer, char[] expected) { // ici nous allons calculé le nombre de nombre qui sont present
        int present = 0;
        int[] stat = new int[expected.length];
        for (char c : answer) {
            for (int expectedIndex = 0; expectedIndex < expected.length; expectedIndex++) {
                if (c == expected[expectedIndex] && stat[expectedIndex] == 0) {
                    present++;
                    stat[expectedIndex] = 1;
                    break;
                }
            }
        }
        return present;
    }

    /**
     * @param answer   an char tab of number of user
     * @param expected an char tab of hidden number expected
     * @return goodPlace : the number of number at goodPlace
     */
    int goodPlace(char[] answer, char[] expected) { // ici nous allons calculé le nombre de nombre a la bonne place
        int goodPlace = 0;
        for (int answerIndex = 0; answerIndex < answer.length; answerIndex++) {
            if (answer[answerIndex] == expected[answerIndex]) {
                goodPlace++;
            }
        }
        return goodPlace;
    }

    /**
     * listPrep prepar the list for the game
     *
     * @param color    number of color in the game
     * @param realSize number of element to find
     * @return the list ready for the game
     */
    ArrayList listPrep(int color, int realSize) {
        int numberInt;
        int a = 0;
        int size = sizeBreak(color, realSize); // permet de crée une boucle basé sur une base numerique differente que la base 10
        for (int i = 0; i < 25; i++)
            System.out.println("");
        System.out.println("AiA : Je rempli la liste qui m'aidera a trouver le bon numéro\n" +
                "sa pourrais prendre un peu de temps si tu as choisi un trop gros nombre ou trop de couleur\n" +
                "par apport aux capacités de ta machine");
        System.out.println("------------------------------------");
        for (int i = 0; i <= size; i++) {
            numberInt = baseConvert(a++, color);
            list.add(convertIntToSringAndPreparForList(numberInt, realSize));
            if (numberInt >= size)
                break;
        }
        for (String s : list) {
            logger.debug("ajout à la liste : " + s);
        }
        return list;
    }

    /**
     * for create an loop break based on numeric base personnalised
     *
     * @param color    the number of color in the party
     * @param realSize the number of element in the party
     * @return the number at use for break loop
     */
    int sizeBreak(int color, int realSize) {
        int number = color - 1;
        realSize -= 1;
        for (int i = 0; i < realSize; i++) {
            number *= 10;
            number += color - 1;
        }
        return number;
    }

    /**
     * make the proposition to User
     *
     * @return return the number proposed
     */
    private int defineProposition() {
        Random r = new Random();
        int indexList;
        indexList = r.nextInt(list.size());
        System.out.println("je te propose : ");
        System.out.println(list.get(indexList));
        return indexList;
    }

    int proposition() {
        int indexList;
        indexList = defineProposition();
        System.out.println("");
        System.out.println("AiA : Combiens y en a-t-il à la bonne place ?");
        return indexList;
    }

    /**
     * delete impossible number for clean the list
     *
     * @param currentChoices the List
     * @param response       the tested number
     * @param turn           the number of turn
     * @return the List
     */
    ArrayList<String> removePossibility(ArrayList<String> currentChoices, String response, int turn, int goodPlace, int present) {
        for (int i = 0; i < currentChoices.size(); i++) {
            String choice = currentChoices.get(i);
            boolean delete;
            if (devMode == true)
                System.out.println(choice);
            delete = checkResponse(choice, response, goodPlace, present);
            if (delete) {
                if (devMode == true)
                    System.out.println(choice + "supprimé");
                currentChoices.remove(choice);
                i--;
            }
        }
        System.out.println("AiA : il ne reste plus que " + currentChoices.size() + " numero dans ma liste");
        if (list.size() < 50 && goodPlace != numberSize)
            System.out.println("AiA : je vais bientôt gagner, attention à toi");
        return currentChoices;
    }

    /**
     * see if response is deletable or not
     *
     * @param choiceOfList the number of list to test
     * @param choiceOfUser the number proposed
     * @return true if deletable
     */
    private boolean checkResponse(String choiceOfList, String choiceOfUser, int goodPlace, int present) {
        int goodPlaceReference;
        int presentReference;
        presentReference = present(choiceOfUser.toCharArray(), choiceOfList.toCharArray());
        goodPlaceReference = goodPlace(choiceOfUser.toCharArray(), choiceOfList.toCharArray());
        if ((present == presentReference) && (goodPlace == goodPlaceReference)) {
            return false;
        }
        return true;
    }
}
