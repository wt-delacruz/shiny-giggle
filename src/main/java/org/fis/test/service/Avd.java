package org.fis.test.service;

import org.fis.test.util.Utilities;
import java.util.concurrent.TimeUnit;

public class Avd {
    final String ADV_PATH = "AVD_PATH";
    final String EMULATOR_PATH = "EMULATOR_PATH";
    private String avdPath;
    private String emulatorPath;

    public Avd() {
        this.avdPath = Utilities.getEnvVarValue(ADV_PATH);
        this.emulatorPath = Utilities.getEnvVarValue(EMULATOR_PATH);
    }

    public void start(String nameOfAVD) {
        String[] aCommand = new String[]{this.emulatorPath, "-avd", nameOfAVD};
        try {
            System.out.println("...Starting Android AVD");
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("...Android AVD started");
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
            System.out.println("...Android AVD stopped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
