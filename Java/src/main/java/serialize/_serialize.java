package serialize;

import java.io.*;

public class _serialize {
    public static void main(String[] args) throws CloneNotSupportedException {
        try {
            // Serialize object to byte array
            Person person = new Person("Alice", 30);
            byte[] serialized = person.serialize();
            System.out.println("Serialized bytes: " + serialized);

            // Deserialize object from byte array
            Person deserialized = Person.deserialize(serialized);
            System.out.println("Deserialized Person: " + deserialized);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = new Person("11", 11);
        Person clone = (Person)person.clone();
        System.out.println(clone.toString());
    }
}

class Person implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    private String name; // 不序列化名字字段
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Person[name=" + name + ", age=" + age + "]";
    }

    // Serialize object to byte array
    public byte[] serialize() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    // Deserialize object from byte array
    public static Person deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Person person = (Person) objectInputStream.readObject();
        objectInputStream.close();
        return person;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}