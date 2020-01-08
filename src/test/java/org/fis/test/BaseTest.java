package org.fis.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public abstract class BaseTest {

    private AppiumDriver driver;
    private static AppiumDriverLocalService server;

    @BeforeSuite
    public void globalSetup() throws IOException {
    }

    @AfterSuite
    public void globalTearDown() {
    }

    public void getServiceUrl() {
    }

}