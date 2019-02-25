package com.resnidar.mastermind;

import com.resnidar.Config;
import org.junit.Test;
import  static org.junit.Assert.*;

public class MastermindChallengerTest {

    @Test
    public void test(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'1', '0', '6', '5'};
        char[] answer = {'1', '0', '6', '5'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,4);
        assertEquals(present, 0);
    }

    @Test
    public void test2(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '5', '0', '0'};
        char[] answer = {'0', '5', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,4);
        assertEquals(present, 0);
    }

    @Test
    public void test3(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'6', '0', '6', '0'};
        char[] answer = {'6', '0', '5', '5'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,2);
        assertEquals(present, 0);
    }

    @Test
    public void test4(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '0', '0', '0'};
        char[] answer = {'0', '0', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,4);
        assertEquals(present, 0);
    }

    @Test
    public void test5(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '0', '5', '0'};
        char[] answer = {'0', '0', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,3);
        assertEquals(present, 0);
    }

    @Test
    public void test6(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'7', '4', '9', '2'};
        char[] answer = {'2', '7', '4', '9'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,0);
        assertEquals(present, 4);
    }

    @Test
    public void test7(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'7', '4', '9', '2'};
        char[] answer = {'2', '4', '2', '9'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,1);
        assertEquals(present, 2);
    }

    @Test
    public void test8(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'7', '2', '9', '2'};
        char[] answer = {'2', '4', '0', '8'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,0);
        assertEquals(present, 1);
    }

    @Test
    public void test9(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'9', '0', '0', '0'};
        char[] answer = {'9', '0', '0', '0'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,4);
        assertEquals(present, 0);
    }

    @Test
    public void test10(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'1', '2', '3', '4'};
        char[] answer = {'5', '6', '7', '8'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,0);
        assertEquals(present, 0);
    }

    @Test
    public void test11(){
        MastermindChallenger mastermindChallenger = new MastermindChallenger(new Config(true));
        char[] expected = {'0', '7', '9', '9'};
        char[] answer = {'0', '9', '7', '9'};
        int present = mastermindChallenger.present(answer, expected);
        int goodPlace = mastermindChallenger.goodPlace(answer, expected);
        present -= goodPlace;
        assertEquals(goodPlace,2);
        assertEquals(present, 2);
    }
}