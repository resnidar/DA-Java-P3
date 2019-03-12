package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(Config config) {
        super(config);
    }
    ArrayList list = new ArrayList();

    @Override
    public boolean logic() {
        Scanner sc = new Scanner(System.in);
        //algo de knuth
        int present = 0;
        int goodPlace = 0;
        listPrep(3, 3);
        System.out.println("la liste est remplie ,le jeu commence");
        System.out.println("je te propose 1122");
        System.out.println("combiens y en a t il a la bonne place ?");
        goodPlace = sc.nextInt();
        System.out.println("combien y en a t il de present ?");
        present = sc.nextInt();
        System.out.println("il y en a " + present + "de present et " + goodPlace + "a la bonne place ");
        removePossibility(list, 0, present, goodPlace);
        return false;
    }

    /***
     * preparation of list for knuth
     *
     * temps de travail pour 7 base 10 : 2 minutes 08
     */
    private void listPrep(int color, int realSize){
        Integer nombre = 0;
        int a = 0;
        int size = sizeBreak(color, realSize);
        while (nombre <= size){
            nombre = baseConvert(a++ , color);
            list.add(nombre);
            if (nombre >= size)
                break;
            System.out.println("remplissage en cour ,veuillez patientez");
        }
        for (int i = 0; i < list.size(); i++){
        System.out.println("liste : " + list.get(i));
        // TODO: 28/02/2019 test unitaire
        }
    }

    public int baseConvert (int a, int b){
        String numberConvert = Integer.toString(a, b);
        return Integer.parseInt(numberConvert);
    }

    public int sizeBreak (int color, int realSize){
        int number = color - 1;
        realSize -= 1;
        for (int i = 0; i < realSize; i++){
            number *= 10;
            number += color - 1;
        }
        return number;
    }

    public ArrayList removePossibility (ArrayList currentChoices, int response, int present, int goodPlace){

        return currentChoices;
    }
}

// TODO: 05/03/2019 faire removePossibility 
// TODO: 19/02/2019 avertir utilisateur des limites
// TODO: 28/02/2019 faire return result