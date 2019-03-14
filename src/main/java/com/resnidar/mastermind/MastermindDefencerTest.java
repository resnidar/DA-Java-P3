package com.resnidar.mastermind;

import com.resnidar.Config;
import org.junit.Test;

import static org.junit.Assert.*;

public class MastermindDefencerTest {

    @Test
    public void test1(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(4, 4);
        assertEquals(3333, size);
    }

    @Test
    public void test2(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(6, 2);
        assertEquals(55, size);
    }

    @Test
    public void test3(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(9, 1);
        assertEquals(8, size);
    }

    @Test
    public void test4(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(2, 8);
        assertEquals(11111111, size);
    }

    @Test
    public void test5(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(3, 3);
        assertEquals(222, size);
    }

    @Test
    public void checkResponse() {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("0000", "0000", 0, 4);
        assertEquals(result, false);
        result = mastermindDefencer.checkResponse("0000", "1122", 0, 4);
        assertEquals(result, true);
    }
}