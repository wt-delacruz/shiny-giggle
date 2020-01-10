package org.fis.test.util;

public class Utilities {

    public static Boolean isEnvVarSet(String envVarName) {
        return System.getenv(envVarName) != null;
    }

    public static String getEnvVarValue(String envVarName) {
        return System.getenv(envVarName);
    }
}
