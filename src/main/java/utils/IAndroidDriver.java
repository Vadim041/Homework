package utils;

import io.appium.java_client.android.AndroidDriver;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IAndroidDriver {

    private static AndroidDriver driver;
    private static final JSONObject emulator = FileUtils.getJsonFile("src/test/resources/emulator.json");

    private IAndroidDriver() {
    }

    public static AndroidDriver getDriver()  {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", emulator.get("deviceName"));
            capabilities.setCapability("platformName", emulator.get("platformName"));
            capabilities.setCapability("app", System.getProperty("user.dir") + emulator.get("app"));
            URL url;
            try {
                url = new URL("http://" + emulator.get("Remote Host") + ":" + emulator.get("Remote Port") + emulator.get("Remote Path"));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            driver = new AndroidDriver(url, capabilities);
        }
        return driver;
    }
}
