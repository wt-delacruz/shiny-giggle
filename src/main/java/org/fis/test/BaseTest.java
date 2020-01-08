package org.fis.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.fis.test.util.Avd;
import org.fis.test.util.appium.AppiumServer;
import org.fis.test.util.appium.DriverConfigurator;
import org.fis.test.util.appium.MobileDeviceConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.URL;


public class BaseTest {
    public AppiumDriver<MobileElement> driver;

    @BeforeSuite
    public void _startAppiumServer(ITestContext context) {
        AppiumServer server = new AppiumServer().start();
        context.setAttribute("appiumServer", server);
    }

    @BeforeTest
    @Parameters({"deviceDescriptorFileName"})
    public void _setMobileDeviceConfiguration(ITestContext context, String deviceDescriptorFileName) {
        DesiredCapabilities capabilities = MobileDeviceConfigurator.set_capabilities(deviceDescriptorFileName);
        String device_name = capabilities.getCapability("deviceName").toString();
        String platformName = capabilities.getCapability("platformName").toString();
        MobileDeviceConfigurator.start_simulators(device_name, platformName);
        context.setAttribute("capabilities", capabilities);
    }

    @BeforeClass
    public void _setUpDriver(ITestContext context) {
        URL serverURL = ((AppiumServer) (context.getAttribute("appiumServer"))).getUrl();
        DesiredCapabilities capabilities = ((DesiredCapabilities) (context.getAttribute("capabilities")));
        this.driver = DriverConfigurator.set(serverURL, capabilities);
    }

    @AfterSuite
    public void _stopAppiumServer(ITestContext context) {
        ((AppiumServer) (context.getAttribute("appiumServer"))).stop();
    }

    @AfterTest
    public void _stopADV(ITestContext context) {
        DesiredCapabilities capabilities = (DesiredCapabilities) (context.getAttribute("capabilities"));
        String platformName = capabilities.getCapability("platformName").toString();
        MobileDeviceConfigurator.stop_simulators(platformName);
    }

    @AfterClass
    public void _quitDriverInstance(ITestContext context) {
        this.driver.quit();
    }
}