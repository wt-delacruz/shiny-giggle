package org.fis.framework.factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public abstract class DriverManager {
    protected AppiumDriver<MobileElement> driver;

    protected abstract void createDriver(URL serverURL, DesiredCapabilities capabilities);

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

    public AppiumDriver<MobileElement> getDriver() {
        return driver;
    }
}

