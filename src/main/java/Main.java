import org.fis.test.service.AppiumServer;
import org.fis.test.service.MobileSettings;

public class Main {
    private static void testAVD() throws Exception{
        MobileSettings mobileSettings = new MobileSettings("29-0-pixel_3xl");
        mobileSettings.setCapabilities();
        System.out.println(mobileSettings.getCapabilities().toJson().toString());
        mobileSettings.startSimulator();
        Thread.sleep(5000);
        mobileSettings.stopSimulator();
    }

    private static void testAppiumServer() throws Exception{
        AppiumServer server = new AppiumServer();
        server.start();
        Thread.sleep(5000);
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        //testAVD();
        testAppiumServer();
    }
}