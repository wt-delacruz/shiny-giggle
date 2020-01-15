package org.fis.test.mma;

import org.fis.framework.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class MMABaseTest extends BaseTest {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage(this.driverManager);
    }

}