package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.IAndroidDriver;

public abstract class BaseForm {

    protected static AndroidDriver driver;

    public BaseForm() {
        this.driver = IAndroidDriver.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
