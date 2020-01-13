package org.fis.framework.service;

import org.fis.framework.util.Utilities;

import java.util.concurrent.TimeUnit;

public class AndroidEmulator {
    final String ADB_PATH = "ADB_PATH";
    final String ANDROID_TOOLS = "ANDROID_TOOLS";
    private String avdPath;
    private String emulatorPath;

    public AndroidEmulator() {
        this.avdPath = Utilities.getEnvVarValue(ADB_PATH);
        this.emulatorPath = Utilities.getEnvVarValue(ANDROID_TOOLS) + "/emulator";
    }

    public void start(String nameOfAVD) {
        String[] aCommand = new String[]{this.emulatorPath, "-avd", nameOfAVD};
        try {
            System.out.println("...Starting Android emulator");
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("...Android emulator started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        System.out.println("...Stopping Android emulator");
        String[] aCommand = new String[]{this.avdPath, "emu", "kill"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("...Android emulator stopped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
