import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] header = {"Value 1", "Value 2", "Value 3"};
        int[][] data = {{1, 2, 3}, {4, 5, 3}, {6, 4, 3}};
        AppData appData = new AppData(header, data);
        String filePath = "src/main/resources/test.csv";

        CsvUtil.save(appData, filePath);

        AppData loadData = CsvUtil.load(filePath);
        System.out.println(Arrays.toString(loadData.getHeader()));
        for (int i = 0; i < loadData.getData().length; i++) {
            System.out.println(Arrays.toString(loadData.getData()[i]));
        }

    }
}
