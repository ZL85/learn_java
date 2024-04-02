package learnjava_16;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

public class ClassTest {
    //获取Class类实例的方式
    @Test
    public void test1() {
        //方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);

        //方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        System.out.println(clazz1 == clazz2);//true

        //方式三：调用Class的静态方法：forName(String classPath)
        try {
            Class clazz3 = Class.forName("learnjava_16.Person");//注意这里的参数是类的全类名
            System.out.println(clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ClassTest.class.getClassLoader();
        try {
            Class clazz4 = classLoader.loadClass("learnjava_16.Person");
            System.out.println(clazz4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = Override.class;
        Class c6 = ElementType.class;
        Class c7 = Integer.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        System.out.println(c10 == c11);
    }

    @Test
    public void test3() {
        //获取系统类加载器
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);//jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b

        //获取扩展类加载器
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@d6da883

        //获取引导类加载器
        ClassLoader classLoader3 = classLoader2.getParent();
        System.out.println(classLoader3);//null

        //用户自定义类是用系统类加载器加载的
        Class clazz = Person.class;
        ClassLoader classLoader4 = clazz.getClassLoader();
        System.out.println(classLoader4);//jdk.internal.loader.ClassLoaders$AppClassLoader@63947c6b
    }
}
