package com.resnidar.mastermind;

import com.resnidar.Config;
import org.junit.Test;

import static org.junit.Assert.*;

public class MastermindDefencerTest {

    @Test
    public void sizebreak0(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(4, 4);
        assertEquals(3333, size);
    }

    @Test
    public void sizebreak1(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(6, 2);
        assertEquals(55, size);
    }

    @Test
    public void sizebreak2(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(9, 1);
        assertEquals(8, size);
    }

    @Test
    public void sizebreak3(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(2, 8);
        assertEquals(11111111, size);
    }

    @Test
    public void sizebreak4(){
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        int size = mastermindDefencer.sizeBreak(3, 3);
        assertEquals(222, size);
    }

    @Test
    public void checkResponse0() {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("0000", "0000");
        assertEquals(result, true);
    }

    @Test
    public void checkResponse1() {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("1234", "5678");
        assertEquals(result, false);
    }

    @Test
    public void checkResponse2() {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("1334", "0199");
        assertEquals(result, true);
    }

    @Test
    public void checkResponse3 () {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("89222", "06799");
        assertEquals(result, true);
    }

    @Test
    public void checkResponse4() {
        MastermindDefencer mastermindDefencer = new MastermindDefencer(new Config(true));
        boolean result = mastermindDefencer.checkResponse("8888", "7777");
        assertEquals(result, false);
    }
}