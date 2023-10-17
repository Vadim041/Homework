import org.junit.jupiter.api.Assertions;
import pages.CartPage;
import pages.MainPage;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WildberriesTest extends BaseTest {

    private final int countItems = 3;
    private final String url = "https://www.wildberries.ru/";
    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Test
    public void cartTest() {
        driver.get(url);

        mainPage.addItemsToCard(countItems);
        List<String> itemNamesMainPage = mainPage.getItemNames(countItems);
        List<Integer> itemPricesMainPage = mainPage.getItemPrices(countItems);

        mainPage.clickCartButton();
        List<String> itemNamesCartPage = cartPage.getItemNames(countItems);
        List<Integer> itemPricesCartPage = cartPage.getItemPrices(countItems);

        Assertions.assertEquals(itemNamesMainPage, itemNamesCartPage, "Item names mismatch");
        Assertions.assertEquals(itemPricesMainPage, itemPricesCartPage, "Item prices mismatch");
        Assertions.assertEquals(cartPage.getTotalSum(), cartPage.calculateTotalSum(itemPricesCartPage), "Total sum mismatch");

    }
}
