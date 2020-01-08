package org.fis.sandbox;

import org.testng.annotations.*;

public class MyFeatureTest2 extends MyFeatureTeamBaseTest {

    @BeforeSuite
    public void ____beforeSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterSuite
    public void ____afterSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @BeforeTest
    public void ____beforeTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterTest
    public void ____afterTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @BeforeClass
    public void ____beforeClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from  %s.%s", className, methodName));
    }

    @AfterClass
    public void ____afterClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @Test
    public void test2() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @BeforeMethod
    public void ____beforeMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterMethod
    public void ____afterMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }
}
