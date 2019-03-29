package com.resnidar.mastermind;

import com.resnidar.Config;
import org.junit.Test;

import static org.junit.Assert.*;

public class MastermindDefenderTest {

    @Test
    public void sizebreak0(){
        MastermindDefender mastermindDefender = new MastermindDefender(new Config(true));
        int size = mastermindDefender.sizeBreak(4, 4);
        assertEquals(3333, size);
    }

    @Test
    public void sizebreak1(){
        MastermindDefender mastermindDefender = new MastermindDefender(new Config(true));
        int size = mastermindDefender.sizeBreak(6, 2);
        assertEquals(55, size);
    }

    @Test
    public void sizebreak2(){
        MastermindDefender mastermindDefender = new MastermindDefender(new Config(true));
        int size = mastermindDefender.sizeBreak(9, 1);
        assertEquals(8, size);
    }

    @Test
    public void sizebreak3(){
        MastermindDefender mastermindDefender = new MastermindDefender(new Config(true));
        int size = mastermindDefender.sizeBreak(2, 8);
        assertEquals(11111111, size);
    }

    @Test
    public void sizebreak4(){
        MastermindDefender mastermindDefender = new MastermindDefender(new Config(true));
        int size = mastermindDefender.sizeBreak(3, 3);
        assertEquals(222, size);
    }


}