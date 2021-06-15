import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        System.out.println("Колличество совершеннолетних: ");
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println(count);

        System.out.println("-----------------------------");
        System.out.println("Фамилии призывников: ");

        List<String> list = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 27)
                .filter(person -> person.getSex() != Sex.WOMAN)
                .map(person -> person.getFamily())
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("------------------------------------");
        System.out.println("С высшим образованием: ");


        List<String> list2 = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getAge() < 60 && person.getSex() == Sex.WOMAN)
                .filter(person -> person.getAge() > 18 && person.getAge() < 65 && person.getSex() == Sex.MAN)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(person -> )
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}
