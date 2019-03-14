package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(Config config) {
        super(config);
    }
    ArrayList<String> list = new ArrayList<String>();

    @Override
    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        //algo de knuth
        int present = 0;
        int goodPlace = 0;
        String response = "1122";
        listPrep(3, 3);
        System.out.println("la liste est remplie ,le jeu commence");
        System.out.println("je te propose 1122");
        System.out.println("combiens y en a t il a la bonne place ?");
        goodPlace = sc.nextInt();
        System.out.println("combien y en a t il de present ?");
        present = sc.nextInt();
        System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
        list = removePossibility(list, response, present, goodPlace);
        return false;
    }

    /***
     * preparation of list for knuth
     *
     * temps de travail pour 7 base 10 : 2 minutes 08
     */
    private ArrayList listPrep(int color, int realSize){
        int numberInt = 0;
        int a = 0;
        int size = sizeBreak(color, realSize); // permet de crée une boucle basé sur une base numerique differente que la base 10
        for (int i = 0 ; i <= size; i++){
            numberInt = baseConvert(a++ , color);
            list.add(convertIntToSringAndPreparForList(numberInt, realSize));
            if (numberInt >= size)
                break;
            System.out.println("remplissage en cour ,veuillez patientez");
        }
        for (int i = 0; i < list.size(); i++){
        System.out.println("liste : " + list.get(i));
        // TODO: 28/02/2019 test unitaire
        }
        return list;
    }

    /**
     *
     * @param numberInt
     * @param realSize
     * @return
     */
    public String convertIntToSringAndPreparForList(int numberInt, int realSize){
        String number = String.valueOf(numberInt);
        String zero = "0";
        while (number.length() < realSize){
            number = zero + number;
        }
        return number;
    }

    /**
     * For convert base 10 in base X
     * @param a is the base 10 for convert to base X
     * @param b is the base X
     * @return int in base X
     */
    public int baseConvert (int a, int b){
        String numberConvert = Integer.toString(a, b);
        return Integer.parseInt(numberConvert);
    }

    /**
     * for create an loop break based on numeric base personnalised
     * @param color the number of color in the party
     * @param realSize the number of element in the party
     * @return the number at use for break loop
     */
    public int sizeBreak (int color, int realSize){
        int number = color - 1;
        realSize -= 1;
        for (int i = 0; i < realSize; i++){
            number *= 10;
            number += color - 1;
        }
        return number;
    }

    /**
     * delete impossible number for clean the list
     * @param currentChoices the List
     * @param response the tested number
     * @param present the number of numero present
     * @param goodPlace the number of numero at the good place
     * @return the List
     */
    public ArrayList<String> removePossibility (ArrayList<String> currentChoices, String response, int present, int goodPlace){
        for (String choice:currentChoices){
            System.out.println(choice);
            checkResponse(choice, response, present, goodPlace);
        }
        return currentChoices;
    }

    /**
     * permet de voir si une réponse doit ètre supprimé ou non
     * @param choice
     * @param response
     * @param present
     * @param goodPlace
     * @return
     */
    public boolean checkResponse(String choice, String response, int present, int goodPlace) {
        // doit retourné true si peut ètre supprimé
     return true;
    }
}

// TODO: 05/03/2019 faire removePossibility 
// TODO: 14/03/2019 faire checkResponse 
// TODO: 19/02/2019 avertir utilisateur des limites