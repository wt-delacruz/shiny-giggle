package org.fis.framework.factory;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManagerFactory {
    public static DriverManager getManager(DriverType type, DesiredCapabilities capabilities, URL serverURL) {
        DriverManager driverManager;

        switch (type) {
            case IOS:
                driverManager = new iOSDriverManager();
                break;
            case ANDROID:
            default:
                driverManager = new AndroidDriverManager();
                break;
        }
        driverManager.createDriver(serverURL,capabilities);
        return driverManager;
    }
}
