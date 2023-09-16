public class Main {

    public static void main(String[] args) {

        String[][] arr = {{"1", "2", "4", "5"},
                          {"1", "2", "ш", "5"},
                          {"1", "6", "4", "1"},
                          {"1", "2", "4", "5"}};

        try {
            System.out.println(ArrayChecker.checkArraySize(arr, 4));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

}
