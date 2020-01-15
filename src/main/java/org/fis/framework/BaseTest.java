package org.fis.framework;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.fis.framework.factory.DriverManager;
import org.fis.framework.factory.DriverManagerFactory;
import org.fis.framework.factory.DriverType;
import org.testng.annotations.*;
import org.testng.ITestContext;
import org.fis.framework.service.DriverSettings;
import org.fis.framework.service.MobileSettings;
import org.fis.framework.service.AppiumServer;

public class BaseTest {
    public AppiumDriver<MobileElement> driver;
    public DriverManager driverManager;

    public enum Settings {
        APPIUM_SERVER,
        MOBILE_SETTINGS;
    }

    @BeforeSuite
    public void _startAppiumServer(ITestContext context) {
        AppiumServer server = new AppiumServer();
        server.start();
        context.getSuite().setAttribute(Settings.APPIUM_SERVER.toString(), server);
    }

    @BeforeTest
    @Parameters({"deviceDescriptorFileName"})
    public void _setMobileDeviceSettings(ITestContext context, String deviceDescriptorFileName) {
        MobileSettings mobileSettings = new MobileSettings(deviceDescriptorFileName);
        mobileSettings.setCapabilities();
        context.setAttribute(Settings.MOBILE_SETTINGS.toString(), mobileSettings);
    }

    @BeforeClass
    public void _setUpDriver(ITestContext context) {
        MobileSettings mobileSettings = ((MobileSettings) (context.getAttribute(Settings.MOBILE_SETTINGS.toString())));
        AppiumServer appiumServer = ((AppiumServer) (context.getSuite().getAttribute(Settings.APPIUM_SERVER.toString())));
        driverManager = DriverManagerFactory.getManager(
                DriverType.ANDROID,
                mobileSettings.getCapabilities(),
                appiumServer.getUrl());

//        this.driver = DriverSettings.set(
//                appiumServer.getUrl(),
//                mobileSettings.getCapabilities());

    }

    @AfterSuite
    public void _stopAppiumServer(ITestContext context) {
        (((AppiumServer) (context.getSuite().getAttribute(Settings.APPIUM_SERVER.toString())))).stop();
    }

    @AfterClass
    public void _quitDriver(ITestContext context) {
        this.driver.quit();
    }
}