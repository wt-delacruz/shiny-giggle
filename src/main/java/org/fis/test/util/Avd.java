package org.fis.test.util;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Avd {
    private static String EMULATOR_PATH = String.format("%s%semulator%semulator",
            System.getenv("ANDROID_HOME"), File.separator, File.separator);
    private static String ADV_PATH = String.format("%s%splatform-tools%sadb",
            System.getenv("ANDROID_HOME"), File.separator, File.separator);

    public static void start(String nameOfAVD) {
        String[] aCommand = new String[]{EMULATOR_PATH, "-avd", nameOfAVD};
        try {
            System.out.println("...Starting emulator");
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("...Emulator started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        System.out.println("...Stopping emulator");
        String[] aCommand = new String[]{ADV_PATH, "emu", "kill"};
        try {
            Process process = new ProcessBuilder(aCommand).start();
            process.waitFor(1, TimeUnit.SECONDS);
            System.out.println("...Emulator stopped");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
