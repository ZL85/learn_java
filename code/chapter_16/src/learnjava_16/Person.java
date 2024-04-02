package learnjava_16;

public class Person {
    private String name;
    public int age;

    public Person() {
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("I'm a person");
    }

    private String showNation(String nation) {
        return "My nationality is " + nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
