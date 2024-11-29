package EncapsulationExample;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative.");
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);
        System.out.printf("Name: %s%n", person.getName());
        System.out.printf("Age: %d%n", person.getAge());

        person.setName("Bob");
        person.setAge(25);
        System.out.printf("Updated Name: %s%n", person.getName());
        System.out.printf("Updated Age: %d%n", person.getAge());

        person.setAge(-5);
    }
}

