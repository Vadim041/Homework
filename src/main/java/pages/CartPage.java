package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.IDriver;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BaseForm {

    @FindBy(xpath = "//p[@class='b-top__total line']//span[@data-link]")
    private WebElement lblTotalSum;
    @FindBy(xpath = "//div[@class='basket-order__b-btn b-btn']")
    private WebElement btnOnlineChat;
    private List<WebElement> items;
    private final String itemNamesXpath = "//span[@class='good-info__good-name']";
    private final String itemPricesXpath = "//div[@class='list-item__price-new']";

    public CartPage() {
        super();
    }

    public List<String> getItemNames(int countItems) {
        waitElementToBeClickable(btnOnlineChat)
                .waitVisibility(lblTotalSum);
        items = IDriver.getDriver().findElements(By.xpath(itemNamesXpath));
        List<String> itemNames = items.stream().map(WebElement::getText)
                .limit(countItems).collect(Collectors.toList());
        Collections.reverse(itemNames);
        return itemNames;
    }

    public List<Integer> getItemPrices(int countItems) {
        waitElementToBeClickable(btnOnlineChat);
        items = IDriver.getDriver().findElements(By.xpath(itemPricesXpath));
        List<Integer> itemPrices = items.stream().map(WebElement::getText)
                .map(s -> s.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .limit(countItems).collect(Collectors.toList());
        Collections.reverse(itemPrices);
        return itemPrices;
    }

    public int getTotalSum(){
        String totalSumText = lblTotalSum.getText().replaceAll("[^0-9]", "");
        int totalSum = Integer.parseInt(totalSumText);
        return totalSum;
    }

    public int calculateTotalSum(List<Integer> itemPrices){
        return itemPrices.stream().mapToInt(Integer::intValue).sum();
    }

}
