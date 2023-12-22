package com.Rawaf.testBase;

import Utilities.PropertiesLoader;



public class ReadProperties {
    public static final String URL = getPropertyFromEnv("URL");
    public static final String FIRST_NAME = getPropertyFromEnv("firstname");
    public static final String LAST_NAME = getPropertyFromEnv("lastname");
    public static final String MOBILE = getPropertyFromEnv("mobile");



    private static String getPropertyFromEnv(String propertyName) {
        return System.getProperty(propertyName, PropertiesLoader.readEnvFile(propertyName));
    }


}
