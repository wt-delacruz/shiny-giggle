package org.fis.test.service;

import org.fis.test.util.config.ConfigLoader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Capabilities {

    public static DesiredCapabilities set(String deviceDescriptorDirPath, String deviceDescriptorFileName) {
        HashMap<String, String> capabilitiesMap = ConfigLoader.load(
                deviceDescriptorDirPath,
                deviceDescriptorFileName);
        return new DesiredCapabilities(capabilitiesMap);
    }
}
