import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] words = {"car", "dog", "car", "cat", "lesson", "task", "citizen", "task", "sunny", "cat", "dog"};

        Map<String, Integer> set = new HashMap<>();

        for (String s : words) {
           set.put(s,set.getOrDefault(s,0)+1);

        }
        for (Map.Entry<String, Integer> s2 : set.entrySet()) {
            System.out.println(s2);
        }


    }
}
