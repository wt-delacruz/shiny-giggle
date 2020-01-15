package org.fis.test.mma;

import org.fis.test.support.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends MMABaseTest {
    @Test
    public void test1() {
        LoginPage loginPage = new LoginPage(this.driverManager);
    }
}
