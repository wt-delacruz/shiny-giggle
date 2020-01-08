package org.fis.test.util.appium;

import org.fis.test.util.Avd;
import org.fis.test.util.config.ConfigLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class MobileDeviceConfigurator {

    public static DesiredCapabilities set_capabilities(String fileName) {
        return CapabilitiesConfigurator.set(fileName);
    }

    public static void start_simulators(String deviceName, String platformName) {
        switch (platformName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                Avd.start(deviceName);
                break;
        }
    }

    public static void stop_simulators(String platformName) {
        switch (platformName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                Avd.stop();
                break;
        }
    }
}
