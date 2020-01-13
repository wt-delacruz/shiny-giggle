package org.fis.framework.service;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.fis.framework.util.Utilities;

import java.io.File;
import java.net.URL;

public class AppiumServer {

    private AppiumDriverLocalService server;

    enum EnvVars {
        NODE_PATH,
        APPIUM_SERVER_PATH;

        private String getValue() {
            return Utilities.getEnvVarValue(this.toString());
        }
    }

    private void setNodeJS(AppiumServiceBuilder serviceBuilder) {
        serviceBuilder.usingDriverExecutable(new File(EnvVars.NODE_PATH.getValue()));
    }

    private void setAppiumNPMPackage(AppiumServiceBuilder serviceBuilder) {
        serviceBuilder.withAppiumJS(new File(EnvVars.APPIUM_SERVER_PATH.getValue()));
    }

    public void start() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.usingAnyFreePort();
        this.setNodeJS(serviceBuilder);
        this.setAppiumNPMPackage(serviceBuilder);
        this.server = AppiumDriverLocalService.buildService(serviceBuilder);
        this.server.start();
        System.out.println(String.format("Appium Server is running on %s.", this.getUrl().toString()));
    }

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
