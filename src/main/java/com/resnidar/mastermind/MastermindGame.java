package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;
import com.resnidar.Games;

public abstract class MastermindGame extends Games implements GameLogic {
    public MastermindGame(Config config) {
        super(config);
    }
}
