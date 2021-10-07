package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE)
        );

        //Imperative
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>();
        for(Person person: people){
            if(person.gender.equals(Gender.FEMALE)){
                females.add(person);
            }
        }

        for(Person female: females){
            System.out.println(female);
        }

        //Declarative approach.
        System.out.println("Declarative approach");
        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);
        List<Person> female2 = people.stream().filter(personPredicate).collect(Collectors.toList());
        female2.forEach(System.out::println );
    }

    public static class Person{
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

    enum Gender{
        MALE , FEMALE
    }
}
