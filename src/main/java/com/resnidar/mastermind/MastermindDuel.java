package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

public class MastermindDuel extends MastermindGame implements GameLogic {
    public MastermindDuel(Config config) {
        super(/*config*/);
    }

    @Override
    public boolean logic() {
        return false;
    }
}
