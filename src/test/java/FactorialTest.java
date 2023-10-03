import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialTest {

    @Test
    public void factorialZeroTest() {
        Assertions.assertEquals(1, Factorial.calculateFactorial(0), "Discrepancy in the factorial of zero");
    }

    @Test
    public void factorialPositiveNumberTest() {
        Assertions.assertEquals(6, Factorial.calculateFactorial(3), "Discrepancy in the factorial of a positive number");
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assertions.assertEquals(6, Factorial.calculateFactorial(-3));
    }

}
