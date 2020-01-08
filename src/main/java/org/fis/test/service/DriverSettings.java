package org.fis.test.service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverSettings {

    public static AppiumDriver<MobileElement> set(URL serverURL, DesiredCapabilities capabilities) {
        AppiumDriver<MobileElement> driver;
        String platformName = capabilities.getPlatform().name();
        switch (platformName) {
            case "Android":
                driver = new AndroidDriver<>(serverURL, capabilities);
                break;
            case "iOS":
                driver = new IOSDriver<>(serverURL, capabilities);
                break;
            default:
                driver = new AppiumDriver<>(serverURL, capabilities);
        }
        return driver;
    }
}
