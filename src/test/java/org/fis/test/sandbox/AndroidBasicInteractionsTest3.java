package org.fis.test.sandbox;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.fis.test.mma.MMABaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class AndroidBasicInteractionsTest3 extends MMABaseTest {

    private final String SEARCH_ACTIVITY = ".app.SearchInvoke";
    private final String PACKAGE = "io.appium.android.apis";

    @Test
    public void testSendKeys3(ITestContext context) {
        AndroidDriver<MobileElement> mobile = ((AndroidDriver<MobileElement>) (this.driverManager.driver));

        mobile.startActivity(new Activity(PACKAGE, SEARCH_ACTIVITY));
        AndroidElement searchBoxEl = (AndroidElement) this.driverManager.driver.findElementById("txt_query_prefill");
        searchBoxEl.sendKeys("Hello world!");
        AndroidElement onSearchRequestedBtn = (AndroidElement) this.driverManager.driver.findElementById("btn_start_search");
        onSearchRequestedBtn.click();
        AndroidElement searchText = (AndroidElement) new WebDriverWait(this.driverManager.driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/search_src_text")));
        String searchTextValue = searchText.getText();
        Assert.assertEquals(searchTextValue, "Hello world!");
    }
}
