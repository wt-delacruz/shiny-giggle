import org.fis.framework.service.AppiumServer;
import org.fis.framework.service.MobileSettings;

public class Main {

    enum Level {
        LOW,
        MEDIUM,
        HIGH;

        private String get(){
            return this.toString();
        }
    }

    private static void testAndroidSimulator() throws Exception {
        MobileSettings mobileSettings = new MobileSettings("29-0-pixel_3xl");
        mobileSettings.setCapabilities();
        System.out.println(mobileSettings.getCapabilities().toJson().toString());
        mobileSettings.startSimulator();
        Thread.sleep(5000);
        mobileSettings.stopSimulator();
    }

    private static void testAppiumServer() throws Exception {
        AppiumServer server = new AppiumServer();
        server.start();
        Thread.sleep(5000);
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(Level.MEDIUM.get());
    }
}