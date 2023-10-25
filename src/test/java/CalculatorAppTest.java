import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import screens.MainScreen;

@DisplayName("Tests of arithmetic actions of the calculator application")
public class CalculatorAppTest {

    MainScreen mainScreen = new MainScreen();

    @BeforeEach
    public void clearField() {
        mainScreen.clickClearButton();
    }

    @Test
    @DisplayName("Checking the result of addition displayed on the screen")
    public void additionTest() {
        String actualResult = mainScreen.performAddition(-100, 1);
        String expectedResult = "−99";
        assertEquals(expectedResult, actualResult, "Doesn't match the results of addition");
    }

    @Test
    @DisplayName("Checking the result of subtraction displayed on the screen")
    public void subtractionTest() {
        String actualResult = mainScreen.performSubtraction(99, 4);
        String expectedResult = "95";
        assertEquals(expectedResult, actualResult, "Doesn't match the results of subtraction");
    }

    @Test
    @DisplayName("Checking the result of multiplication displayed on the screen")
    public void multiplicationTest() {
        String actualResult = mainScreen.performMultiplication(1, 4, 3);
        String expectedResult = "12";
        assertEquals(expectedResult, actualResult, "Doesn't match the results of multiplication");
    }

    @Test
    @DisplayName("Checking the result of division displayed on the screen")
    public void divisionTest() {
        String actualResult = mainScreen.performDivision(1, 4);
        String expectedResult = "0.25";
        assertEquals(expectedResult, actualResult, "Doesn't match the results of division");
    }

}
