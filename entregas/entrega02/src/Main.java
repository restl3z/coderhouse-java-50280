import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Person personA = new Person("Juan", "Lopez");
        Person personB = new Person("Damian", "Perez");
        Person personC = new Person("Mariana", "Gonzalez");
        Person personD = new Person("Eliana", "Alvarez");
        Person personE = new Person("Javier", "Gutierrez");

        Person[] personsList = new Person[]{personA, personB, personC, personD, personE};

        System.out.println("\nOriginal array:");
        for (Person person : personsList) {
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
        }

        Arrays.sort(personsList, Comparator.comparing(Person::getFirstName));

        System.out.println("\nArray sorted by first name:");
        for (Person person : personsList) {
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
        }

        Arrays.sort(personsList, Comparator.comparing(Person::getLastName));

        System.out.println("\nArray sorted by last name:");
        for (Person person : personsList) {
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
        }

        Arrays.sort(personsList, Comparator.comparing(Person::getLastName, (p1, p2) -> {
            return p2.compareTo(p1);
        }));

        System.out.println("\nArray sorted by last name (descending order):");
        for (Person person : personsList) {
            System.out.printf("%s %s\n", person.getFirstName(), person.getLastName());
        }
    }
}