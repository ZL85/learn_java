package learnjava_17;

import org.junit.jupiter.api.Test;

public class RecordTest {
    @Test
    public void test1() {
        //record的使用
        //jdk14之前
        class Employee {
            private String name;
            private int age;

            public Employee(String name, int age) {
                this.name = name;
                this.age = age;
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
                this.age = age;
            }

            @Override
            public String toString() {
                return "Employee{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }

        Employee employee = new Employee("Tom", 20);
        System.out.println(employee);
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
    }

    @Test
    public void test2() {
        //record的使用
        //jdk14之后
        record Employee(String name, int age) {
            //可以在这里添加自定义方法
            public String name() {
                return name;
            }

            public int age() {
                return age;
            }

            //也可以在这里添加自定义方法
        }

        Employee employee = new Employee("Tom", 20);
        System.out.println(employee);
        System.out.println(employee.name());
        System.out.println(employee.age());
    }
}
