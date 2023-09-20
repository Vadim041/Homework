import java.util.*;

public class Main {

    public static void main(String[] args) {
        //1
        String[] words = {"car", "dog", "car", "cat", "lesson", "task", "citizen", "task", "sunny", "cat", "dog", "dog"};
        Map<String, Integer> set = new HashMap<>();

        for (String s : words) {
            int count = set.getOrDefault(s, 0);
            set.put(s, count + 1);
        }

        for (Map.Entry<String, Integer> s2 : set.entrySet()) {
            System.out.println(s2);
        }

        //2
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ванов", "+7676");
        phoneBook.add("Ванов", "+76276");
        phoneBook.add("Петров", "+37653493");

        System.out.println(phoneBook.get("Ванов"));
        System.out.println(phoneBook.get("Петров"));

    }
}
