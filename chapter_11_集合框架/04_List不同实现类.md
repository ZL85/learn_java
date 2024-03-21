# 04_List不同实现类

[`ArrayList`](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)：线程不安全，效率高，底层使用`Object[]`数组存储。在添加，查找时效率高，但在插入，删除时效率低。

[`Vector`](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html)：线程安全，效率低，底层使用`Object[]`数组存储。

[`LinkedList`](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)：底层使用双向链表的方式存储。在添加，查找时效率低，但在插入，删除时效率高。

```java
import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入学生信息：");

        ArrayList list = new ArrayList();

        while (true) {
            System.out.println("|1:继续录入 | 0:结束录入|");
            int option = scanner.nextInt();

            if (option == 0) {
                break;
            } else if (option == 1) {
                System.out.println("请输入学生姓名：");
                String name = scanner.next();
                System.out.println("请输入学生年龄：");
                int age = scanner.nextInt();

                Student s = new Student(name, age);

                list.add(s);
            }
        }

        System.out.println("遍历学生信息：");

        for (Object o : list) {
            Student s = (Student) o;
            System.out.println(o.toString());
        }

        scanner.close();
    }
}
```

```java
import java.util.Objects;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return age == student.age && Objects.equals(name, student.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }
}
```

