package Jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class JacksonExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Serialize object to JSON string
            Person person = new Person("Alice", 30);
            String jsonString = objectMapper.writeValueAsString(person);
            System.out.println("Serialized JSON string: " + jsonString);

            // Deserialize JSON string to object
            Person deserializedPerson = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
