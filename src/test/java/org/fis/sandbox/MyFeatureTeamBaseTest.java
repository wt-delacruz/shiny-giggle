package org.fis.sandbox;

import org.testng.annotations.*;

public class MyFeatureTeamBaseTest extends BaseTest {
    @BeforeSuite
    public void __beforeSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterSuite
    public void __afterSuiteMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @BeforeTest
    public void __beforeTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterTest
    public void __afterTestMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @BeforeClass
    public void __beforeClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterClass
    public void __afterClassMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @BeforeMethod
    public void __beforeMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }

    @AfterMethod
    public void __afterMethodMethod() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println(String.format("Printing from %s.%s",className, methodName));
    }
}
