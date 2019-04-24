package com.resnidar;

import org.apache.log4j.Logger;

public class Main {
private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("-dev")) {
                System.out.println("l'argument -dev a bien été prise en compte, le programme est donc en mode développeur  ");
                Menu menu = new Menu(true);
                menu.logic();
            } else {
                System.err.println("il y a une erreur ,le seul argument accepté est -dev,\n" +
                        "sinon vous pouvez lancer le programme sans arguments");
            }
        }
        else {
            Menu menu = new Menu(false);
            menu.logic();
        }
        logger.debug("la class Menu est instanciée");
        logger.debug("lancement de la methode logic de la class menu");
    }
}