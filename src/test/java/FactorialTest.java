import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {

    @Test
    public void factorialZeroTest() {
        Assert.assertEquals(Factorial.calculateFactorial(0), 1, "Discrepancy in the factorial of zero");
    }

    @Test
    public void factorialPositiveNumberTest() {
        Assert.assertEquals(Factorial.calculateFactorial(3), 6, "Discrepancy in the factorial of a positive number");
    }

    @Test
    public void factorialNegativeNumberTest() {
        Assert.assertEquals(Factorial.calculateFactorial(-3), 6);
    }

}

