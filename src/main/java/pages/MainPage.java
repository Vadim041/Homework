package pages;

import org.openqa.selenium.support.FindBy;
import utils.IDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;


public class MainPage extends BaseForm {

    @FindBy(xpath = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']")
    private WebElement btnCart;
    @FindBy(xpath = "//button[@class='btn-main']")
    private WebElement btnAddToCart;
    @FindBy(xpath = "//a[@class='j-close popup__close close']")
    private WebElement btnClose;
    @FindBy(xpath = "(//div[@class='swiper-container '])[1]")
    private WebElement banner;
    @FindBy(xpath = "//h2[@class='goods__header section-header']")
    private WebElement lblHit;
    private List<WebElement> items;
    private final String itemsXpath = "//div[@class='product-card__tips product-card__tips--bottom']";
    private final String itemNamesXpath = "//span[@class='product-card__name']";
    private final String itemPricesXpath = "//ins[@class='price__lower-price']";
    private List<WebElement> btnSizes;
    private final String btnSizesXPath = "//li[@class='sizes-list__item']";

    public MainPage() {
        super();
    }

    public MainPage addItemsToCard(int countItems) {
        waitElementToBeClickable(banner)
                .scrollTo(banner)
                .waitVisibility(lblHit);
        items = IDriver.getDriver().findElements(By.xpath(itemsXpath));

        for (int i = 0; i < countItems; i++) {
            moveAndClick(items.get(i))
                    .waitElementToBeClickable(btnAddToCart);
            btnSizes = IDriver.getDriver().findElements(By.xpath(btnSizesXPath));
            waitElementToBeClickable(btnAddToCart);
            if (btnSizes.size() > 0) {
                moveAndClick(btnSizes.get(0));
            }
            moveAndClick(btnAddToCart)
                    .waitElementToBeClickable(btnClose)
                    .moveAndClick(btnClose);
        }
        return this;
    }

    public MainPage clickCartButton() {
        btnCart.click();
        return this;
    }

    public List<String> getItemNames(int countItems) {
        items = IDriver.getDriver().findElements(By.xpath(itemNamesXpath));
        return items.stream().map(WebElement::getText)
                .map(text -> text.replace("/", "").trim())
                .limit(countItems).collect(Collectors.toList());
    }

    public List<Integer> getItemPrices(int countItems) {
        items = IDriver.getDriver().findElements(By.xpath(itemPricesXpath));
        return items.stream().map(WebElement::getText)
                .map(s -> s.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .limit(countItems).collect(Collectors.toList());
    }

}
