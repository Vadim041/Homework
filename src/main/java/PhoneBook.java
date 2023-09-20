import java.util.*;

public class PhoneBook {

    Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String secondName, String phoneNumber) {
        List<String> numbers = phoneBook.getOrDefault(secondName, new ArrayList<>());
        numbers.add(phoneNumber);
        phoneBook.put(secondName,numbers);
    }

    public List<String> get(String secondName){
        return phoneBook.getOrDefault(secondName, new ArrayList<>());
    }
}
