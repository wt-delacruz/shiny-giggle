package org.fis.framework.pageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.fis.framework.service.DriverManager;

public class BasePage {
    private final DriverManager driverManager;
    protected AppiumDriver<MobileElement> driver;
    protected String platformName;

    public BasePage(DriverManager driverManager) {
        this.driverManager = driverManager;
        this.driver = this.driverManager.getDriver();
        this.platformName = this.driverManager.platformName;
    }

    public void print(){
        System.out.println("hei fom base page");
    }
}
