package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(Config config) {
        super(config);
    }

    private ArrayList<String> list = new ArrayList<String>();

    @Override
    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        int present;
        int goodPlace;
        int numberOfTurns = 0;
        int size = 6;
        boolean win = false;
        int restart;
        int indexToListForDelete;
        listPrep(8, size);
        System.out.println("la liste est remplie ,le jeu commence");
        while (!win) {
            indexToListForDelete = proposition(numberOfTurns, size);
            goodPlace = sc.nextInt();
            System.out.println("combien y en a t il de present ?");
            present = sc.nextInt();
            System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
            if (present == 0 && goodPlace == 0){
                list = removePossibility(list, list.get(indexToListForDelete), numberOfTurns);
            }
            else if (goodPlace == numberSize) {
                win = true;
                System.out.println("tu a gagné bien joué ! veut tu recommencer ?");
                System.out.println("0 pour oui  \n1 pour non");
                restart = sc.nextInt();
                if (restart == 0)
                    return true;
                else if (restart == 1)
                    return false;
            }
            else {
                System.out.println(list.get(indexToListForDelete) + "supprimé");
                list.remove(indexToListForDelete);
            }
            numberOfTurns++;
        }
        return false;
    }

    private int proposition(int numberOfTurns, int size) {
        int number;
        String stringNumber;
        if (numberOfTurns == 0) {
            System.out.println("je te propose : " + firstProposition(size));
            stringNumber = firstProposition(size);
            number = Integer.parseInt(stringNumber);
        }
        else{
            number = defineProposition();
        }
        System.out.println("combiens y en a t il a la bonne place ?");
        return number;
    }

    //je n en suis pas fière ,en attente d une meilleur idée bien que sa marche parfaitement dans ce cas ci
    private String firstProposition(int size){
        switch (size){
            case 1:
                return "1";
            case 2 :
                return "12";
            case 3:
                return "112";
            case 4:
                return "1122";
            case 5:
                return "11222";
            case 6:
                return "111222";
            case 7:
                return "1111222";
            case 8:
                return "11112222";
            case 9:
                return "111122222";
        }
        return "0";
    }
    
    private int defineProposition(){
        Random r = new Random();
        int number;
        number = r.nextInt(list.size());
        System.out.println("je te propose : ");
        System.out.println(list.get(number));
        // TODO: 18/03/2019 définir les propositions
        return number;
    }

    /**
     * listPrep prepar the list for the game
     * @param color number of color in the game
     * @param realSize number of element to find
     * @return the list ready for the game
     */
    private ArrayList listPrep(int color, int realSize) {
        int numberInt;
        int a = 0;
        int size = sizeBreak(color, realSize); // permet de crée une boucle basé sur une base numerique differente que la base 10
        for (int i = 0; i <= size; i++) {
            numberInt = baseConvert(a++, color);
            list.add(convertIntToSringAndPreparForList(numberInt, realSize));
            if (numberInt >= size)
                break;
            System.out.println("remplissage en cour ,veuillez patientez");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println("liste : " + list.get(i));
        }
        return list;
    }

    /**
     * can convert int in string and add 0 if the number is too short
     *
     * @param numberInt the number in int
     * @param realSize  the size of the number
     * @return the number modified in String and ready for list
     */
    private String convertIntToSringAndPreparForList(int numberInt, int realSize) {
        String number = String.valueOf(numberInt);
        String zero = "0";
        while (number.length() < realSize) {
            number = zero + number;
        }
        return number;
    }

    /**
     * For convert base 10 in base X
     *
     * @param a is the base 10 for convert to base X
     * @param b is the base X
     * @return int in base X
     */
    private int baseConvert(int a, int b) {
        String numberConvert = Integer.toString(a, b);
        return Integer.parseInt(numberConvert);
    }

    /**
     * for create an loop break based on numeric base personnalised
     *
     * @param color    the number of color in the party
     * @param realSize the number of element in the party
     * @return the number at use for break loop
     */
    public int sizeBreak(int color, int realSize) {
        int number = color - 1;
        realSize -= 1;
        for (int i = 0; i < realSize; i++) {
            number *= 10;
            number += color - 1;
        }
        return number;
    }

    /**
     * delete impossible number for clean the list
     *
     * @param currentChoices the List
     * @param response       the tested number
     * @param turn           the number of turn
     * @return the List
     */
    public ArrayList<String> removePossibility(ArrayList<String> currentChoices, String response,int turn) {
        for (int i = 0; i < currentChoices.size(); i++) {
            String choice = currentChoices.get(i);
            boolean delete = false;
            if (turn != 0) {
                System.out.println(choice);
                delete = checkResponse(choice, response);
            }
            else if (turn == 0) {
                System.out.println(choice);
                delete = checkResponse(choice, firstProposition(response.length()));
            }
            if (delete) {
                System.out.println(choice + "supprimé");
                currentChoices.remove(choice);
                i--;
            }
        }
        System.out.println("il ne reste plus que " + currentChoices.size() + " numero dans la liste");
        return currentChoices;
    }

    /**
     * see if response is deletable or not
     *
     * @param choice   the number of list to test
     * @param response the number proposed
     * @return true if deletable
     */
    public boolean checkResponse(String choice, String response) {
        for (int i = 0; i < choice.length(); i++) {
            for (int j = 0; j < choice.length(); j++) {
                if (choice.charAt(j) == response.charAt(i))
                    return true;
            }
        }
        return false;
    }
}

// TODO: 19/02/2019 avertir utilisateur des limites