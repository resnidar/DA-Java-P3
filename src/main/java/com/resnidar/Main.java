package com.resnidar;

import org.apache.log4j.Logger;

public class Main {
static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("-dev")) {
                System.out.println("c'est bien rentrer dans dev avec option -dev");
                Menu menu = new Menu(true);
                menu.logic();
            } else {
                System.err.println("il y a une erreur ,argument accepté : -dev");
            }
        }
        else {
            System.out.println("c'est bien rentré dans dev");
            Menu menu = new Menu(false);
            menu.logic();
        }
            // TODO: 29/01/2019 forcé le gameMode
            // TODO: 29/01/2019 bug si pas de argument !!!!
            // TODO: 29/01/2019 a faire absolument ! terminé cette partie
        logger.debug("la class Menu est instancier");
        logger.debug("lancement de la methode logic de la class menu");
    }
}
// TODO: 29/01/2019  : a faire : algo
// TODO: 29/01/2019 une seul fois le new config

// TODO: 07/02/2019 test de git 