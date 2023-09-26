import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //1
        int[] randomArr = new Random().ints(10, 0, 100).filter(x -> x % 2 == 0).toArray();
        Arrays.stream(randomArr).forEach(System.out::println);

        //2
        List<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, "Highload", "High", "Load", "Highload");

        long res = arrayList.stream().filter(e -> e.equals("High")).count();
        System.out.println("Count 'High': " + res);

        String firstWord = arrayList.stream().findFirst().orElse("0");
        System.out.println("First word: " + firstWord);

        String lastWord = arrayList.stream().skip(arrayList.size() - 1).findFirst().orElse("0");
        System.out.println("Last word: " + lastWord);

        //3
        List<String> arrayListWithF = new ArrayList<>();
        Collections.addAll(arrayListWithF, "f10", "f15", "f2", "f4", "f4");
        List<String> sorted = arrayListWithF.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1)))).collect(Collectors.toList());
        System.out.println(sorted);


        //4
        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 27, Gender.MAN));

        OptionalDouble avrAgeMan = students.stream().filter(m -> m.getSex() == Gender.MAN)
                .map(Student::getAge).mapToInt(Integer::intValue).average();
        System.out.println("Average age of men: " + avrAgeMan.getAsDouble());

        List<Student> soldiers = students.stream().filter(m -> m.getSex() == Gender.MAN && m.getAge() >= 18 && m.getAge() <= 27)
                .collect(Collectors.toList());
        System.out.println("Future soldiers: " + soldiers);

        //5
        LoginProgram.loginChecker();
    }
}

