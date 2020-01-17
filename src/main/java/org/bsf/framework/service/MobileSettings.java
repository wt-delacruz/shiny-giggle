package org.bsf.framework.service;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileSettings {

    final String DEVICE_DESCRIPTOR_DIR_PATH = "src/test/resources/device-descriptors";
    private String deviceDescriptorFileName;
    private DesiredCapabilities capabilities;

    public MobileSettings(String deviceDescriptorFileName) {
        this.deviceDescriptorFileName = deviceDescriptorFileName;
    }

    public DesiredCapabilities getCapabilities() {
        return this.capabilities;
    }

    public void setCapabilities() {
        this.capabilities = Capabilities.set(
                this.DEVICE_DESCRIPTOR_DIR_PATH,
                this.deviceDescriptorFileName);
    }
}
