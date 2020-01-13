package org.fis.sandbox;

import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest1 {

    @BeforeSuite
    public void _beforeSuiteMethod(ITestContext context) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("...Starting Appium Server");
        context.setAttribute("server", "A server instance");
    }

    @AfterSuite
    public void _afterSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("...Stopping Appium Server");
    }

    @BeforeTest
    public void _beforeTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("org.fis.sandbox.BaseTest.beforeTestMethod()...Setting capabilities for device to be automated");
    }

    @AfterTest
    public void _afterTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("...Nothing in particular");
    }

    @BeforeClass
    public void _beforeClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("...Start AVD and getting a driver's instance");
    }

    @AfterClass
    public void _afterClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from from %s.%s", className, methodName));
        System.out.println("...Killing AVD and quiting driver's instance");
    }

    @BeforeMethod
    public void _beforeMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterMethod
    public void _afterMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }
}
