package validating;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        //Note: this passes the tests but it may be better to have two separate blocks
        //and error messages for invalid names and ages.
        if (name == null || name.isEmpty() || name.length() > 40 ||
        age < 0 || age > 120) {
            throw new IllegalArgumentException("Invalid name or age.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
