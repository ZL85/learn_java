# 10_Annotation注解

注解格式：`@注解名`。Annotation 可以用于修饰、类、构造器、方法属性、参数、局部变量声明。还可以添加一些参数值，这些信息被保存在 Annotation 的`name = value`对中。注解可以在类编译、运行时进行加载，体现不同的功能。

![image-20240308151714192](https://cdn.jsdelivr.net/gh/ZL85/ImageBed@main//202403081517243.png)

```java
public @interface AnnotationTest {
    String value();
}
```

```java
@AnnotationTest("类")
public class Employee {
    private String name;
    private int age;
    private Status status;

    public Employee() {
    }

    public Employee(String name, int age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}
```

```java
@AnnotationTest("枚举类型")
public enum Status {
    BUSY, FREE, VACATION, DISMISSAL;
}
```

```java
public class EmployeeTest {
    @AnnotationTest("main方法，程序入口")
    public static void main(String[] args) {
        Employee e = new Employee("Tom", 21, Status.DISMISSAL);
        System.out.println(e);
    }
}
```

