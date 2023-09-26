import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginProgram {

    public static void loginChecker(){
        Scanner sc = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Enter logins: ");

        while (true){
            String login = sc.nextLine().trim();
            if (login.isEmpty()){
                break;
            } else {
                logins.add(login);
            }
        }

        List<String> filterLogins = logins.stream().filter(l -> l.startsWith("f")).collect(Collectors.toList());

        if (filterLogins.isEmpty()){
            System.out.println("Logins with the letter f were not found");
        } else {
            System.out.println("Logins with the letter f: ");
            filterLogins.forEach(System.out::println);
        }
    }
}
