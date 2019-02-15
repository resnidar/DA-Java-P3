package com.resnidar.mastermind;

import com.resnidar.Config;
import org.junit.Test;

public class MastermindChallengerTest {

    /*@org.junit.Test
    public void test1() {
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'1', '0', '6', '5'};
        char[] answer = {'1', '0', '6', '5'};
        int[] test = mastermindChallenger.test(expected, answer);
        //todo compter les 1 et 2
    }

    @org.junit.Test
    public void test2() {
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'5', '0', '0', '3'};
        char[] answer = {'5', '0', '0', '3'};
        int[] test = mastermindChallenger.test(expected, answer);
        //todo compter les 1 et 2
        assert getBienPlacé(test) == 4;
        assert getMalPlacé(test) == 0;
    }
    
    public int getBienPlacé(int[] stat){
        //todo compté les 2
    return 0;}

    public int getMalPlacé(int[] stat){
        //todo compté les 1
    return 0;}*/

    @Test
    public void test(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'1', '0', '6', '5'};
        char[] answer = {'1', '0', '6', '5'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 4;
        assert getPresent(present) == 0;
    }

    @Test
    public void test2(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '5', '0', '0'};
        char[] answer = {'0', '5', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 4;
        assert getPresent(present) == 0;
    }

    @Test
    public void test3(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'6', '0', '6', '0'};
        char[] answer = {'6', '0', '6', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 4;
        assert getPresent(present) == 0;
    }

    @Test
    public void test4(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '0', '0', '0'};
        char[] answer = {'0', '0', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 4;
        assert getPresent(present) == 0;
    }

    @Test
    public void test5(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '0', '5', '0'};
        char[] answer = {'0', '0', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 3;
        assert getPresent(present) == 0;
    }

    @Test
    public void test6(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'7', '4', '9', '2'};
        char[] answer = {'2', '7', '4', '9'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assert getGoodPlace(goodPlace) == 0;
        assert getPresent(present) == 4;
    }

    public int getPresent(int present){
        return present;
    }

    public int getGoodPlace(int goodPlace){
        return goodPlace;
    }
}

// TODO: 12/02/2019 faire TDD !! 
