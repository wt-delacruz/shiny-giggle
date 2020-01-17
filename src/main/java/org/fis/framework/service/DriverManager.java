package org.fis.framework.service;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {

    private AppiumDriver<MobileElement> driver;
    private URL serverURL;
    private DesiredCapabilities capabilities;
    public String platformName;

    public DriverManager(URL serverURL, DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
        this.serverURL = serverURL;
        this.platformName = this.capabilities.getPlatform().name();
        this.set();
    }

    private void set() {
        switch (this.platformName) {
            case "iOS":
                this.driver = new IOSDriver<>(serverURL, this.capabilities);
                break;
            case "Android":
            default:
                this.driver = new AndroidDriver<>(serverURL, this.capabilities);
                break;
        }
    }

    public AppiumDriver<MobileElement> getDriver(){
        return this.driver;
    }
}
