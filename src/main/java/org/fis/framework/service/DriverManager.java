package org.fis.framework.service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {

    public static AppiumDriver<MobileElement> set(URL serverURL, DesiredCapabilities capabilities) {
        AppiumDriver<MobileElement> driver;
        String platformName = capabilities.getPlatform().name();
        switch (platformName) {
            case "iOS":
                driver = new IOSDriver<>(serverURL, capabilities);
                break;
            case "Android":
            default:
                driver = new AndroidDriver<>(serverURL, capabilities);
                break;
        }
        return driver;
    }
}
