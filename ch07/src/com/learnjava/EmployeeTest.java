package com.learnjava;

public class EmployeeTest {
    @AnnotationTest("main方法，程序入口")
    public static void main(String[] args) {
        Employee e = new Employee("Tom", 21, Status.DISMISSAL);
        System.out.println(e);
    }
}
