package org.fis.test.util;

public class Utilities {

    public static Boolean isEnvVarSet(String envVarName) {
        return System.getenv(envVarName) != null;
    }
}
