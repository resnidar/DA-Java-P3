package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

public class MastermindDuel extends MastermindGame implements GameLogic {
    public MastermindDuel(boolean devMode, int life, int numberSize) {
        super(devMode, life, numberSize);
    }

    @Override
    public boolean logic() {
        return false;
    }
}
