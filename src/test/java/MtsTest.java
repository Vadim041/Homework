import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsTest extends BaseTest {

    private final String url = "https://www.mts.by";
    private final By lblOnlinePayBlock = By.xpath("//section[@class='pay']/div/h2");
    private final By lblPayCards = By.xpath("//div[@class='pay__partners']//li/img");
    private final By btnAcceptCookies = By.xpath("//button[@id='cookie-agree']");
    private final By btnService = By.xpath("//section[@class='pay']//a");
    private final By btnContinue = By.xpath("//section[@class='pay']//button[@type='submit']");
    private final By txbPhoneNumber = By.xpath("//input[@class='phone']");
    private final By txbSum = By.xpath("//input[@class='total_rub']");
    private final By payContainer = By.xpath("//div[@class='bepaid-app']");
    private final String mainPageTitle = "МТС – мобильный оператор в Беларуси";
    private final String helpPageTitle = "Порядок оплаты и безопасность интернет платежей";
    private final String onlinePayBlockName = "Онлайн пополнение\nбез комиссии";
    private final String phoneNumber = "297777777";
    private final String payAmount = "10";
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void payBlockTest() {
        driver.get(url);
        Assertions.assertEquals(mainPageTitle, driver.getTitle(), "The main page didn't open");
        driver.findElement(btnAcceptCookies).click();

        Assertions.assertEquals(onlinePayBlockName, driver.findElement(lblOnlinePayBlock).getText(), "Invalid onlinePayBlock name");

        List<WebElement> cards = driver.findElements(lblPayCards);
        for (WebElement card : cards) {
            Assertions.assertTrue(card.isDisplayed(), card.getAttribute("alt") + "isn't displayed");
        }

        driver.findElement(btnService).click();
        Assertions.assertEquals(helpPageTitle, driver.getTitle(), "The help page didn't open");
        driver.navigate().back();
        Assertions.assertEquals(mainPageTitle, driver.getTitle(), "The main page didn't open");

        driver.findElement(txbPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(txbSum).sendKeys(payAmount);
        driver.findElement(btnContinue).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(payContainer));
        Assertions.assertTrue(driver.findElement(payContainer).isDisplayed(), "The pay container isn't displayed");

    }

}
