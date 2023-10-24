package utils;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class FileUtils {

    public static JSONObject jsonObject;

    public static JSONObject getJsonFile(String file) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(file));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
