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


}