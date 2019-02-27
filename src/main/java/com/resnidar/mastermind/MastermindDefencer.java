package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

import java.util.ArrayList;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(Config config) {
        super(config);
    }
    ArrayList list = new ArrayList();

    @Override
    public boolean logic() {
        //algo de knuth
        listPrep();
        return false;
    }

    private void listPrep(){
        Integer nombre;
        int a = 0;
        for (int i = 0; i < 10; i++){
            nombre = baseConvert(a++ , 3);
            list.add(nombre);
            System.out.println("taille nombre : ");
        }
        for (int i = 0; i < list.size(); i++){
            System.out.println("liste : " + list.get(i));
        }
    }

    public int baseConvert (int a, int b){
        String numberConvert = Integer.toString(a, b);
        return Integer.parseInt(numberConvert);
    }
}


// TODO: 19/02/2019 preparé method avec signature method
// TODO: 19/02/2019 avertir utilisateur des limites
