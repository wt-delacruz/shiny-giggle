package org.fis.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.fis.framework.BaseTest;
import org.fis.framework.factory.DriverManagerFactory;
import org.fis.framework.factory.DriverType;
import org.fis.framework.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FactoryPatternTest extends BaseTest {
    DriverManager driverManager;

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driverManager.quitDriver();
    }

    @Test
    public void launchTest(){
        //doing something with "driver"
    }
}
