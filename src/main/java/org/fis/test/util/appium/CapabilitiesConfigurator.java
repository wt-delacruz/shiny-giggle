package org.fis.test.util.appium;

import org.fis.test.util.config.ConfigLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class CapabilitiesConfigurator {

    private static final String DEVICE_DESCRIPTOR_DIR_PATH = "src/test/resources/device-descriptors";

    public static DesiredCapabilities set(String deviceDescriptorFileName) {
        HashMap<String, String> capabilitiesMap = ConfigLoader.load(DEVICE_DESCRIPTOR_DIR_PATH,
                deviceDescriptorFileName);
        DesiredCapabilities caps = new DesiredCapabilities();
        capabilitiesMap.forEach(caps::setCapability);
        return caps;
    }
}
