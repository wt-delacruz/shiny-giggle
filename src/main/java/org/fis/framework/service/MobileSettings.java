package org.fis.framework.service;

import org.openqa.selenium.remote.DesiredCapabilities;

public class MobileSettings {

    final String DEVICE_DESCRIPTOR_DIR_PATH = "src/test/resources/device-descriptors";
    private String deviceDescriptorFileName;
    private DesiredCapabilities capabilities;
    private AndroidEmulator androidEmulator;

    public MobileSettings(String deviceDescriptorFileName) {
        this.deviceDescriptorFileName = deviceDescriptorFileName;
        this.androidEmulator = new AndroidEmulator();
    }

    public DesiredCapabilities getCapabilities() {
        return this.capabilities;
    }

    public void setCapabilities() {
        this.capabilities = Capabilities.set(
                this.DEVICE_DESCRIPTOR_DIR_PATH,
                this.deviceDescriptorFileName);
    }

    public void startSimulator() {
        String deviceName = this.capabilities.getCapability("deviceName").toString();
        String platformName = this.capabilities.getCapability("platformName").toString();
        switch (platformName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                this.androidEmulator.start(deviceName);
                break;
        }
    }

    public void stopSimulator() {
        String platformName = this.capabilities.getCapability("platformName").toString();
        switch (platformName) {
            case "iOS":
                //todo
                break;
            case "Android":
            default:
                this.androidEmulator.stop();
                break;
        }
    }
}
