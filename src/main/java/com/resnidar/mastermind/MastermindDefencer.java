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

    ArrayList<String> list = new ArrayList<String>();

    @Override
    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        int present = 0;
        int goodPlace = 0;
        int numberOfTurns = 0;
        boolean win = false;
        int restart;
        int indexToListForDelete;
        String response = "1122";
        listPrep(4, 4);
        System.out.println("la liste est remplie ,le jeu commence");
        while (!win) {
            indexToListForDelete = Proposition(numberOfTurns, 4);
            goodPlace = sc.nextInt();
            System.out.println("combien y en a t il de present ?");
            present = sc.nextInt();
            System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
            if (present == 0 && goodPlace == 0) {
                list = removePossibility(list, response);
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

    private int Proposition(int numberOfTurns, int size) {
        int number = 0;
        if (numberOfTurns == 0) {
            firstProposition(size);
        }
        else{
            number = defineProposition();
        }
        System.out.println("combiens y en a t il a la bonne place ?");
        return number;
    }

    //je n en suis pas fière ,en attente d une meilleur idée bien que sa marche parfaitement dans ce cas ci
    private void firstProposition(int size){
        switch (size){
            case 1:
                System.out.println("je te propose 1");
                break;
            case 2 :
                System.out.println("je te propose 12");
                break;
            case 3:
                System.out.println("je te propose 112");
                break;
            case 4:
                System.out.println("je te propose 1122");
                break;
            case 5:
                System.out.println("je te propose 11222");
                break;
            case 6:
                System.out.println("je te propose 111222");
                break;
            case 7:
                System.out.println("je te propose 1111222");
                break;
            case 8:
                System.out.println("je te propose 11112222");
                break;
            case 9:
                System.out.println("je te propose 111122222");
                break;
        }
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
        int numberInt = 0;
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
    public String convertIntToSringAndPreparForList(int numberInt, int realSize) {
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
    public int baseConvert(int a, int b) {
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
     * @return the List
     */
    public ArrayList<String> removePossibility(ArrayList<String> currentChoices, String response) {
        int verif = 0;
        for (int i = 0; i < currentChoices.size(); i++) {
            String choice = currentChoices.get(i);
            boolean delete = false;
            System.out.println(choice);
            delete = checkResponse(choice, response);
            if (delete == true) {
                System.out.println(choice + "supprimé");
                currentChoices.remove(choice);
                verif++;
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