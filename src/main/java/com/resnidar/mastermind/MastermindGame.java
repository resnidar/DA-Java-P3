package com.resnidar.mastermind;

import com.resnidar.GameLogic;
import com.resnidar.Games;

public abstract class MastermindGame extends Games implements GameLogic {
    public MastermindGame(boolean devMode, int life, int numberSize) {
        super(devMode, life, numberSize);
    }
}
