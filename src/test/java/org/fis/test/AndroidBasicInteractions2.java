package org.fis.test;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.fis.test.service.AppiumServer;

import java.io.File;

public class AndroidBasicInteractions2 extends BaseTest {

    private AndroidDriver driver;
    private static AppiumServer server;
    private final String SEARCH_ACTIVITY = ".app.SearchInvoke";
    private final String ALERT_DIALOG_ACTIVITY = ".app.AlertDialogSamples";
    private final String PACKAGE = "io.org.fis.test.util.appium.android.apis";

    @BeforeTest
    public static void startAppiumServer() {
        server = new AppiumServer();
        server.start();
    }

    @AfterTest
    public static void stopAppiumServer() {
        server.stop();
    }

    @BeforeClass
    public void setup() {
        try {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File appDir = new File(classpathRoot, "../../resources/apps");
            File app = new File(appDir.getCanonicalPath(), "ApiDemos-debug.apk");

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 XL API 29");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            capabilities.setCapability("app", app.getAbsolutePath());

            //URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(server.getUrl(), capabilities);
            //driver = new AndroidDriver(url, capabilities);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }


    @Test()
    public void testSendKeys() {
        driver.startActivity(new Activity(PACKAGE, SEARCH_ACTIVITY));
        AndroidElement searchBoxEl = (AndroidElement) driver.findElementById("txt_query_prefill");
        searchBoxEl.sendKeys("Hello world!");
        AndroidElement onSearchRequestedBtn = (AndroidElement) driver.findElementById("btn_start_search");
        onSearchRequestedBtn.click();
        AndroidElement searchText = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")));
        String searchTextValue = searchText.getText();
        Assert.assertEquals(searchTextValue, "Hello world!");
    }
}
