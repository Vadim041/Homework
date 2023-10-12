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
import java.util.stream.Collectors;

public class MtsTest extends BaseTest {

    private final String url = "https://www.mts.by";
    private final String mainPageTitle = "МТС – мобильный оператор в Беларуси";
    private final By btnAcceptCookies = By.xpath("//button[@id='cookie-agree']");
    private final By btnContinue = By.xpath("//section[@class='pay']//button[@type='submit']");
    private final By txbPhoneNumber = By.xpath("//input[@class='phone']");
    private final By txbSum = By.xpath("//input[@class='total_rub']");
    private final By txbAccountNumber = By.xpath("//input[@class='score']");
    private final By txbEmail = By.xpath("//input[@class='email']");
    private final By txbCardData = By.xpath("//div[@class='card ng-tns-c52-0']//label");
    private final By lblCardIcon = By.xpath("//div[@class='cards-brands ng-tns-c46-1']/div/img");
    private final By iFramePay = By.xpath("//iframe[@class='bepaid-iframe']");
    private final By headerPaymentAmount = By.xpath("//p[@class='header__payment-amount']");
    private final By headerPaymentPhoneNumber = By.xpath("//p[@class='header__payment-info']");
    private final By btnPaymentAmount = By.xpath("//div[@class='card-page__card']/button");
    private final String expPhoneNumberText = "Номер телефона";
    private final String expHomeNumberText = "Номер абонента";
    private final String expSumText = "Сумма";
    private final String expEmailText = "E-mail для отправки чека";
    private final String expAccount44 = "Номер счета на 44";
    private final String expAccount2073 = "Номер счета на 2073";
    private final String expCardNumber = "Номер карты";
    private final String expDate = "Срок действия";
    private final String expCVC = "CVC";
    private final String expHolderName = "Имя держателя (как на карте)";
    private final String phoneNumber = "297777777";
    private final String payAmount = "10.50";
    String placeHolderAttribute = "placeholder";
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Test
    public void payBlockTest() {
        driver.get(url);
        Assertions.assertEquals(mainPageTitle, driver.getTitle(), "The main page didn't open");
        driver.findElement(btnAcceptCookies).click();

        List<String> txbPhoneNumberList = driver.findElements(txbPhoneNumber)
                .stream().map(e -> e.getAttribute(placeHolderAttribute)).collect(Collectors.toList());
        List<String> txbSumList = driver.findElements(txbSum)
                .stream().map(e -> e.getAttribute(placeHolderAttribute)).collect(Collectors.toList());
        List<String> txbAccountNumberList = driver.findElements(txbAccountNumber)
                .stream().map(e -> e.getAttribute(placeHolderAttribute)).collect(Collectors.toList());
        List<String> txbEmailList = driver.findElements(txbEmail)
                .stream().map(e -> e.getAttribute(placeHolderAttribute)).collect(Collectors.toList());

        Assertions.assertEquals(expPhoneNumberText, txbPhoneNumberList.get(0) );
        Assertions.assertEquals(expSumText, txbSumList.get(0));
        Assertions.assertEquals(expEmailText, txbEmailList.get(0));

        Assertions.assertEquals(expHomeNumberText, txbPhoneNumberList.get(1));
        Assertions.assertEquals(expSumText, txbSumList.get(1));
        Assertions.assertEquals(expEmailText, txbEmailList.get(1));

        Assertions.assertEquals(expAccount44, txbAccountNumberList.get(0));
        Assertions.assertEquals(expSumText, txbSumList.get(2));
        Assertions.assertEquals(expEmailText, txbEmailList.get(2));

        Assertions.assertEquals(expAccount2073, txbAccountNumberList.get(1));
        Assertions.assertEquals(expSumText, txbSumList.get(3));
        Assertions.assertEquals(expEmailText, txbEmailList.get(3));

        driver.findElement(txbPhoneNumber).sendKeys(phoneNumber);
        driver.findElement(txbSum).sendKeys(payAmount);
        driver.findElement(btnContinue).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFramePay));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txbCardData));

        List<String> txbCardDataList = driver.findElements(txbCardData)
                .stream().map(e -> e.getText()).collect(Collectors.toList());
        Assertions.assertEquals(expCardNumber, txbCardDataList.get(0));
        Assertions.assertEquals(expDate, txbCardDataList.get(1));
        Assertions.assertEquals(expCVC, txbCardDataList.get(2));
        Assertions.assertEquals(expHolderName, txbCardDataList.get(3));

        String actHeaderPaymentAmount = driver.findElement(headerPaymentAmount).getText()
                .replaceAll("[А-яA-z]", "").trim();
        String actHeaderPhoneNumber = driver.findElement(headerPaymentPhoneNumber).getText()
                .replaceAll("[^0-9]", "").trim();
        String actButtonPaymentAmount = driver.findElement(btnPaymentAmount).getText()
                .replaceAll("[А-яA-z]", "").trim();
        Assertions.assertEquals(payAmount, actHeaderPaymentAmount);
        Assertions.assertEquals("375" + phoneNumber, actHeaderPhoneNumber);
        Assertions.assertEquals(payAmount, actButtonPaymentAmount);

        List<WebElement> cards = driver.findElements(lblCardIcon);
        for (WebElement card : cards) {
            Assertions.assertTrue(card.isDisplayed());
        }

        driver.switchTo().defaultContent();
    }

}