package org.fis.framework.factory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class iOSDriverManager extends DriverManager {

    @Override
    public void createDriver(URL serverURL, DesiredCapabilities capabilities) {
        driver = new IOSDriver<MobileElement>(serverURL, capabilities);
    }
}
