package com.resnidar;

import org.apache.log4j.Logger;

public class Main {
static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Menu menu = new Menu();
        logger.debug("la class Menu est instancier");
        logger.debug("lancement de la methode logic de la class menu");
        menu.logic();
    }
}