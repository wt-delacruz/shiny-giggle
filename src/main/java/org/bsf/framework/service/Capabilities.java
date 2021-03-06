package org.bsf.framework.service;

import org.bsf.framework.util.ConfigReader;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Capabilities {

    public static DesiredCapabilities set(String deviceDescriptorDirPath, String deviceDescriptorFileName) {
        HashMap<String, String> capabilitiesMap = ConfigReader.load(
                deviceDescriptorDirPath,
                deviceDescriptorFileName);
        return new DesiredCapabilities(capabilitiesMap);
    }
}
