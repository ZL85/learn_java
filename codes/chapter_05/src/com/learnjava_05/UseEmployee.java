package com.learnjava_05;

public class UseEmployee {
    public static void main(String[] args) {
        //创建实例
        Employee employee = new Employee();
        System.out.println(employee);

        //给成员变量赋值
        employee.id = 1;
        employee.name = "zl";
        employee.age = 24;
        employee.salary = 30000;
        employee.birthday = new Birthday();
        employee.birthday.year = 1999;
        employee.birthday.month = 7;
        employee.birthday.day = 26;

        //调用成员方法
        employee.printInfo();
        employee.congratulateBirthday();
    }
}
