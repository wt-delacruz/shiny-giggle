package org.fis.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.annotations.*;
import org.fis.test.service.AppiumServer;
import org.fis.test.service.DriverSettings;
import org.fis.test.service.MobileSettings;
import org.testng.ITestContext;

public class BaseTest {
    public AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void _startAppiumServer(ITestContext context) {
        AppiumServer server = new AppiumServer();
        server.start();
        context.setAttribute("appiumServer", server);
    }

    @BeforeTest
    @Parameters({"deviceDescriptorFileName"})
    public void _setMobileDeviceSettings(ITestContext context, String deviceDescriptorFileName) {
        MobileSettings mobileSettings = new MobileSettings(deviceDescriptorFileName);
        mobileSettings.setCapabilities();
        mobileSettings.startSimulator();
        context.setAttribute("mobileSettings", mobileSettings);
    }

    @BeforeClass
    public void _setUpDriver(ITestContext context) {
        MobileSettings mobileSettings = ((MobileSettings) (context.getAttribute("mobileSettings")));
        AppiumServer appiumServer = ((AppiumServer) (context.getAttribute("appiumServer")));
        this.driver = DriverSettings.set(
                appiumServer.getUrl(),
                mobileSettings.getCapabilities());
    }

    @AfterSuite
    public void _stopAppiumServer(ITestContext context) {
        ((AppiumServer) (context.getAttribute("appiumServer"))).stop();
    }

    @AfterTest
    public void _stopADV(ITestContext context) {
        MobileSettings mobileSettings = ((MobileSettings) (context.getAttribute("mobileSettings")));
        mobileSettings.stopSimulator();
    }

    @AfterClass
    public void _quitDriverInstance(ITestContext context) {
        this.driver.quit();
    }
}