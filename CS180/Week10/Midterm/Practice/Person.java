import java.util.Objects;

public class Person implements Identifiable {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        if (name == null) { throw new NullPointerException(); }
        if (age == 0) { throw new IllegalArgumentException(); }
        this.name = name;
        this.age = age;
    }

    public Person(Person person) {
        if (person == null) { throw new NullPointerException(); }
        name = person.getName();
        age = person.getAge();
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public boolean equals(Object object) {
        if (object instanceof Person) {
            return ((Person) object).getAge() == age && Objects.equals(((Person) object).getName(), name);
        }
        return false;
    }

    public String toString() {
        return String.format("Person<name=%s, age=%d>", name, age);
    }
}
