package org.fis.test.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.fis.test.util.Utilities;

import java.io.File;
import java.net.URL;

public class AppiumServer {

    final String NODE_PATH_ENVVAR_NAME = "NODE_PATH";
    final String APPIUM_SERVER_PATH_ENVVAR_NAME = "APPIUM_SERVER_PATH";
    private String nodePath;
    private String appiumServerPath;
    private AppiumDriverLocalService server;

    public AppiumServer() {
        this.nodePath = Utilities.getEnvVarValue(NODE_PATH_ENVVAR_NAME);
        this.appiumServerPath = Utilities.getEnvVarValue(APPIUM_SERVER_PATH_ENVVAR_NAME);
    }

    private void setNodeJS(AppiumServiceBuilder serviceBuilder) {
        serviceBuilder.usingDriverExecutable(new File(this.nodePath));
    }

    private void setAppiumNPMPackage(AppiumServiceBuilder serviceBuilder) {
        serviceBuilder.withAppiumJS(new File(this.appiumServerPath));
    }

    /**
     * Starts the Appium Server using the "AppiumServiceBuilder" class.
     * <p>
     * This method will, first, try to use the parameters (node_path and appium_server_path)
     * defined in "configuration.yml". If these variables are not set, it will try to use
     * the environment variables NODE_PATH and APPIUM_PATH.
     */
    public void start() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        this.setNodeJS(serviceBuilder);
        this.setAppiumNPMPackage(serviceBuilder);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.server.start();
        System.out.println(String.format("Appium Server is running on %s.", this.getUrl().toString()));
    }

    /**
     * Stops the Appium Server.
     */
    public void stop() {
        this.server.stop();
        System.out.println(String.format("Appium Server running on %s has been stopped.", this.getUrl().toString()));
    }

    /**
     * Gets the current Appium Server URL
     */
    public URL getUrl() {
        return server.getUrl();
    }
}
