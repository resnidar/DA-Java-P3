package com.resnidar;

import org.apache.log4j.Logger;

public class Log4j {
    public Log4j() {
    this.log4j();
}
    private static Logger logger = Logger.getLogger(Log4j.class);

    public static void log4j(){
        logger.debug("messsage de debogage");
        logger.info("message d'information");
        logger.warn("message d avertissement");
        logger.error("message d erreur");
        logger.error("message d erreur fatal");
    }
}