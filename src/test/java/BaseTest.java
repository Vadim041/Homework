import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.IDriver;

public abstract class BaseTest {

    protected static WebDriver driver = IDriver.getDriver();

    @BeforeAll
    public static void setUp(){
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
