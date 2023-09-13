import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvUtil {

    public static void save(AppData appData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.join(";", appData.getHeader()));
            writer.newLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < appData.getData().length; i++) {
                for (int j = 0; j < appData.getData()[i].length; j++) {
                    sb.append(appData.getData()[i][j]);
                    if (j < appData.getData()[i].length - 1) {
                        sb.append(";");
                    }
                }
                writer.write(sb.toString());
                sb.setLength(0);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AppData load(String filePath) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            String[] header = lines.get(0).split(";");
            int row = lines.size() - 1;
            int column = lines.get(0).split(";").length;
            int[][] data = new int[row][column];

            for (int i = 1; i <= row; i++) {
                String[] values = lines.get(i).split(";");
                for (int j = 0; j < column; j++) {
                    data[i-1][j] = Integer.parseInt(values[j]);
                }
            }
            return new AppData(header, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

