package learnjava_16;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    //使用反射之前可执行的操作
    @Test
    public void test1() {
        //创建Person类实例
        Person p1 = new Person();

        //通过对象调用类的属性和方法
        p1.age = 12;
        System.out.println(p1.age);
        p1.show();

    }

    //使用反射完成上述操作
    @Test
    public void test2() {
        //创建Person类实例
        try {
//            Class clazz = Person.class;
//            Person p1 = (Person) clazz.newInstance();
            Class<Person> clazz = Person.class;
            Person p1 = clazz.newInstance();
            System.out.println(p1);

            //通过对象调用类的属性和方法
            Field ageField = clazz.getField("age");
            ageField.set(p1, 20);
            System.out.println(ageField.get(p1));

            Method showMethod = clazz.getMethod("show");
            showMethod.invoke(p1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //通过反射，调用Person类的私有结构
    @Test
    public void test3() {
        try {
            Class<Person> clazz = Person.class;

            //调用私有的构造器
            Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            Person p1 = constructor.newInstance("Tom", 12);
            System.out.println(p1);

            //调用私有的属性
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(p1, "Jerry");
            System.out.println(nameField.get(p1));

            //调用私有的方法
            Method showNation = clazz.getDeclaredMethod("showNation", String.class);
            showNation.setAccessible(true);
            String nation = (String) showNation.invoke(p1, "China");
            System.out.println(nation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
