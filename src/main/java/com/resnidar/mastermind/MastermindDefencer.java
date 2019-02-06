package com.resnidar.mastermind;

import com.resnidar.GameLogic;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(boolean devMode, int life, int numberSize) {
        super(devMode, life, numberSize);
    }

    @Override
    public boolean logic() {
        return false;
    }
}
