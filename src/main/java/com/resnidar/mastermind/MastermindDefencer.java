package com.resnidar.mastermind;

import com.resnidar.Config;
import com.resnidar.GameLogic;

public class MastermindDefencer extends MastermindGame implements GameLogic {
    public MastermindDefencer(Config config) {
        super(config);
    }

    @Override
    public boolean logic() {
        //algo de knuth
        return false;
    }
}

// TODO: 19/02/2019 preparé method avec signature method
// TODO: 19/02/2019 avertir utilisateur des limites
