package org.fis.test.service;

import org.fis.test.util.config.ConfigLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class CapabilitiesSettings {

    private static final String DEVICE_DESCRIPTOR_DIR_PATH = "src/test/resources/device-descriptors";

    public static DesiredCapabilities set(String deviceDescriptorFileName) {
        HashMap<String, String> capabilitiesMap = ConfigLoader.load(DEVICE_DESCRIPTOR_DIR_PATH,
                deviceDescriptorFileName);
        return new DesiredCapabilities(capabilitiesMap);
    }
}
