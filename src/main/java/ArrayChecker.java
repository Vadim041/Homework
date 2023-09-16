public class ArrayChecker {
    public static int checkArraySize(String[][] array, int size) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (array.length != size) {
            throw new MyArraySizeException("Incorrect number of rows");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != size) {
                throw new MyArraySizeException("Incorrect number of columns");
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Incorrect value in coordinates: ",i,j);
                }
            }
        }
        return sum;
    }
}
