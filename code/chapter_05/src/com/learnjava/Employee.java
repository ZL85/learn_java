package com.learnjava;

public class Employee {
    int id;
    String name;
    int age;
    double salary;
    Birthday birthday;

    public void printInfo() {
        System.out.println("id: " + id + "\n" + "name: " + name + "\n" +
                "age: " + age + "\n" + "salary: " + salary + "\n" +
                "birthday: " + birthday.year + birthday.month + birthday.day);
    }

    public void congratulateBirthday() {
        birthday.congratulate(name);
    }
}
