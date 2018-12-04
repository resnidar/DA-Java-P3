package com.resnidar;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private int numberSize = 0;
    public Config() {
        readConfig();
    }
    public void readConfig(){
         Properties prop = new Properties();
         try {
             InputStream input = new FileInputStream("src/main/resources/config.properties");
             prop.load(input);
             numberSize = Integer.parseInt(prop.getProperty("numberSize"));
         } catch (java.io.IOException e) {
             e.printStackTrace();
         }
     }

    public int getNumberSize() {
        return numberSize;
    }
}