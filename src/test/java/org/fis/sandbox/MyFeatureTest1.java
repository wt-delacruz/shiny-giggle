package org.fis.sandbox;

import org.testng.ITestContext;
import org.testng.annotations.*;

public class MyFeatureTest1 extends MyFeatureTeamBaseTest {
    @BeforeSuite
    public void ___beforeSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterSuite
    public void ___afterSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @BeforeTest
    public void ___beforeTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterTest
    public void ___afterTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @BeforeClass
    public void ___beforeClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @AfterClass
    public void ___afterClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
    }

    @Test
    public void test1(ITestContext context) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s", className, methodName));
        System.out.println(String.format("Printing from %s.%s", className, methodName));
        System.out.println(String.format("Server status: %s", context.getAttribute("server")));

    }
    @BeforeMethod
    public void ___beforeMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterMethod
    public void ___afterMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }
}