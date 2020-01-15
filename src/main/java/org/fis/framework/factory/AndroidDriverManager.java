package org.fis.framework.factory;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AndroidDriverManager extends DriverManager {

    @Override
    public void createDriver(URL serverURL, DesiredCapabilities capabilities){
        driver = new AndroidDriver<>(serverURL, capabilities);
    }
}
