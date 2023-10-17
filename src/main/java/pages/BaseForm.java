package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.IDriver;

import java.time.Duration;

public abstract class BaseForm {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Actions actions;

    public BaseForm() {
        this.driver = IDriver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public BaseForm scrollTo(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public BaseForm waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public BaseForm waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public BaseForm hoverAndClick(WebElement element1, WebElement element2) {
        actions.moveToElement(element1).build().perform();
        actions.click(element2).build().perform();
        return this;
    }

    public BaseForm moveAndClick(WebElement element) {
        actions.moveToElement(element).click().build().perform();
        return this;
    }

}
