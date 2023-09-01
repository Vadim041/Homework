import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson_3 {

    public static void main(String[] args) {
        Lesson_3 lesson_3 = new Lesson_3();

        int[] zeroOne = new int[]{0, 1, 1, 0, 1, 0, 1, 0, 0};
        int[] arr1 = new int[100];
        int[] arr2 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] arr3 = new int[3][3];

        System.out.println(lesson_3.checkRangeNumbers(0, 20)); //1

        lesson_3.checkPositiveInt(0); //2

        System.out.println(lesson_3.isNegativeInt(-10)); //3

        lesson_3.printRepeatedText(2, "Text"); //4

        System.out.println(lesson_3.isLeapYear(400)); //5

        for (int i = 0; i < zeroOne.length; i++) { //6
            if (zeroOne[i] == 0) {
                zeroOne[i] = 1;
            } else if (zeroOne[i] == 1) {
                zeroOne[i] = 0;
            }
        }
        System.out.println(Arrays.toString(zeroOne));

        for (int i = 0; i < arr1.length; i++) { //7
            arr1[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr1));

        for (int i = 0; i < arr2.length; i++) { //8
            if (arr2[i] < 6) {
                arr2[i] = arr2[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr2));

        for (int i = 0; i < arr3.length; i++) {      //9
            for (int j = 0; j < arr3[0].length; j++) {
                if (i == j) {
                    arr3[i][j] = 1;
                }
                arr3[i][arr3[0].length - i - 1] = 1;
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(lesson_3.lenInitial(4, 10))); //10
    }

    public boolean checkRangeNumbers(int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public void checkPositiveInt(int a) {
        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    public boolean isNegativeInt(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printRepeatedText(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int[] lenInitial(int len, int initialValue) {
        int[] arr1 = new int[len];
        for (int i = 0; i < len; i++) {
            arr1[i] = initialValue;
        }
        return arr1;
    }

}
