package streams;


import java.util.List;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );

        people.stream()
                .map(person -> person.name)
                .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .anyMatch(person -> person.gender.equals(Gender.FEMALE));

        System.out.println("containsOnlyFemales = " + containsOnlyFemales);

    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    public enum Gender{
        MALE , FEMALE
    }
}
