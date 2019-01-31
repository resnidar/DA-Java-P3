package com.resnidar;

import org.apache.log4j.Logger;

public class Main {
static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        boolean forcedDevMod = false;
        if (args[0].equalsIgnoreCase("-dev")){
            Config config = new Config(true);
        }
            // TODO: 29/01/2019 forcé le gameMode
            // TODO: 29/01/2019 bug si pas de argument !!!!
            // TODO: 29/01/2019 a faire absolument ! terminé cette partie
        Menu menu = new Menu(forcedDevMod);
        logger.debug("la class Menu est instancier");
        logger.debug("lancement de la methode logic de la class menu");
        menu.logic();
    }
}
// TODO: 29/01/2019  : a faire : algo
// TODO: 29/01/2019 une seul fois le new config