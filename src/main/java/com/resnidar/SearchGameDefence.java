package com.resnidar;

import org.apache.log4j.Logger;

public class SearchGameDefence extends SearchGame {
    static Logger logger = Logger.getLogger(SearchGameDefence.class);

    public SearchGameDefence(Config config) {
        super(config);
    }

    boolean logic(){
        boolean restart = false;
        logger.debug("searchGame en mode defensif actif");
        System.out.println("mode logique actif");
        return restart;
    }

}
// TODO: 17/12/2018 demander a l utilisateur le nombre secret
// TODO: 17/12/2018 demander a l ia de trouver le nombre secret

