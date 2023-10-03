public class Factorial {

    public static int calculateFactorial(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("The number must be non-negative");
        } else {
            int result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            return result;
        }
    }
}
