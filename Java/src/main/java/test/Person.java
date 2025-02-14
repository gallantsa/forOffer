package test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author gallantsa
 * @version 1.0
 * @date 2025年02月14日 18:27
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        System.out.println(set.size());

    }
}
