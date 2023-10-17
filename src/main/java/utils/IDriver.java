package utils;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDriver {
    private static WebDriver driver;

    private IDriver(){
    }

    public static WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        return driver;
    }

}
