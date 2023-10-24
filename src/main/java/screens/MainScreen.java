package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainScreen extends BaseForm {

    @AndroidFindBy(accessibility = "equals")
    private WebElement btnEquals;
    @AndroidFindBy(accessibility = "divide")
    private WebElement btnDivide;
    @AndroidFindBy(accessibility = "multiply")
    private WebElement btnMultiply;
    @AndroidFindBy(accessibility = "minus")
    private WebElement btnMinus;
    @AndroidFindBy(accessibility = "plus")
    private WebElement btnPlus;
    @AndroidFindBy(accessibility = "clear")
    private WebElement btnClear;
    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    private WebElement lblResult;

    public MainScreen() {
        super();
    }

    public String performAddition(int... numbers) {
        if (numbers.length < 2){
            throw new IllegalArgumentException("Enter 2 or more numbers");
        }
        enterNumber(numbers[0]);
        for (int n = 1; n < numbers.length; n++) {
            clickPlusButton().enterNumber(numbers[n]);
        }
        clickEqualsButton();
        return getResult();
    }

    public String performSubtraction(int... numbers) {
        if (numbers.length < 2){
            throw new IllegalArgumentException("Enter 2 or more numbers");
        }
        enterNumber(numbers[0]);
        for (int n = 1; n < numbers.length; n++) {
            clickMinusButton().enterNumber(numbers[n]);
        }
        clickEqualsButton();
        return getResult();
    }

    public String performMultiplication(int... numbers) {
        if (numbers.length < 2){
            throw new IllegalArgumentException("Enter 2 or more numbers");
        }
        enterNumber(numbers[0]);
        for (int n = 1; n < numbers.length; n++) {
            clickMultiplyButton().enterNumber(numbers[n]);
        }
        clickEqualsButton();
        return getResult();
    }

    public String performDivision(int... numbers) {
        if (numbers.length < 2){
            throw new IllegalArgumentException("Enter 2 or more numbers");
        }
        enterNumber(numbers[0]);
        for (int n = 1; n < numbers.length; n++) {
            clickDivideButton().enterNumber(numbers[n]);
        }
        clickEqualsButton();
        return getResult();
    }

    public MainScreen enterNumber(int number) {
        String numberStr = String.valueOf(number);
        if (number < 0) {
            numberStr = numberStr.substring(1);
            clickMinusButton();
        }
        for (char digitChar : numberStr.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            driver.findElement(AppiumBy.accessibilityId(String.format("%d", digit))).click();
        }
        return this;
    }

    public MainScreen clickDivideButton() {
        btnDivide.click();
        return this;
    }

    public MainScreen clickMultiplyButton() {
        btnMultiply.click();
        return this;
    }

    public MainScreen clickMinusButton() {
        btnMinus.click();
        return this;
    }

    public MainScreen clickPlusButton() {
        btnPlus.click();
        return this;
    }

    public MainScreen clickEqualsButton() {
        btnEquals.click();
        return this;
    }

    public MainScreen clickClearButton() {
        btnClear.click();
        return this;
    }

    public String getResult() {
        return lblResult.getText();
    }

}
