package org.fis.test.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.fis.test.util.Utilities;
import org.fis.test.util.config.ConfigLoader;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

public class AppiumServer {

    private final String NODE_PATH_VAR_NAME = "NODE_PATH";
    private final String APPIUM_SERVER_PATH_VAR_NAME = "APPIUM_PATH";
    private final String CONFIG_DIR_PATH = "src/main/resources";
    private final String CONFIG_FILE_NAME = "appium_server";
    private AppiumDriverLocalService server;
    private HashMap<String, String> appiumServerParameters;

    public AppiumServer() {
        this.appiumServerParameters = ConfigLoader.load(CONFIG_DIR_PATH, CONFIG_FILE_NAME);
    }

    private void setNodeJS(AppiumServiceBuilder serviceBuilder) {
        String path;
        if (Utilities.isEnvVarSet(NODE_PATH_VAR_NAME)) {
            path = System.getenv(NODE_PATH_VAR_NAME);
        } else {
            path = this.appiumServerParameters.get(NODE_PATH_VAR_NAME);
        }
        serviceBuilder.usingDriverExecutable(new File(path));
    }

    private void setAppiumNPMPackage(AppiumServiceBuilder serviceBuilder) {
        String path;
        if (Utilities.isEnvVarSet(APPIUM_SERVER_PATH_VAR_NAME)) {
            path = System.getenv(APPIUM_SERVER_PATH_VAR_NAME);
        } else {
            path = this.appiumServerParameters.get(APPIUM_SERVER_PATH_VAR_NAME);
        }
        serviceBuilder.withAppiumJS(new File(path));
    }

    /**
     * Starts the Appium Server using the "AppiumServiceBuilder" class.
     * <p>
     * This method will, first, try to use the parameters (node_path and appium_server_path)
     * defined in "appium_server.yml". If these variables are not set, it will try to use
     * the environment variables NODE_PATH and APPIUM_PATH.
     */
    public AppiumServer start() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        this.setNodeJS(serviceBuilder);
        this.setAppiumNPMPackage(serviceBuilder);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.server.start();
        System.out.println(String.format("Appium Server is running on %s.", this.getUrl().toString()));
        return this;
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
