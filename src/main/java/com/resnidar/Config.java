package com.resnidar;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Logger logger = Logger.getLogger(Config.class);

    private int numberSize = 0;
    private boolean devMode = false;
    public Config() {
        readConfig();
    }

    /**
     * cette methode permet la lecture du .properties
     */
    public void readConfig(){
         Properties prop = new Properties();
         try {
                 logger.debug("lecture du fichier log4j.xml");
                 InputStream input = new FileInputStream("src/main/resources/config.properties");
                 prop.load(input);
             numberSize = Integer.parseInt(prop.getProperty("numberSize"));
             devMode = Boolean.getBoolean(prop.getProperty("devMode"));
         } catch (java.io.IOException e) {
             e.printStackTrace();
             logger.error("erreur a la lecture du fichier", e);
         }
     }

    public int getNumberSize() {
        return numberSize;
    }
    public boolean getDevMode(){return devMode;}
}