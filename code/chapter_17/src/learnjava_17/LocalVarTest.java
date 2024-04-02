package learnjava_17;

import org.junit.jupiter.api.Test;

public class LocalVarTest {
    @Test
    public void test1() {
        //jdk10的局部变量类型推断
        //局部变量类型推断
        //1.声明变量时，根据所赋的值，推断变量的类型
        var num = 10;
        var list = "hello";
        var arr = new int[]{1, 2, 3};
        var arr2 = new String[]{"tom", "jerry"};
        var arr3 = new int[3];
        var arr4 = new int[]{1, 2, 3};

        //编译时，会根据所赋的值，推断变量的类型
        //等效于
        int num1 = 10;
        String list1 = "hello";
        int[] arr1 = new int[]{1, 2, 3};
        String[] arr21 = new String[]{"tom", "jerry"};
        int[] arr31 = new int[3];
        int[] arr41 = new int[]{1, 2, 3};

        //2.默认类型推断只能在局部变量中使用，不适用于成员变量

        //3.使用var声明变量时，必须要初始化
        //var num2;

        //4.使用var声明变量时，不能赋值为null
        //var num3 = null;

        //5.使用var声明变量时，不能使用var来声明形参
        //public void test(var num){}

        //6.使用var声明变量时，不能定义为数组
        //var arr5 = {1, 2, 3};

        //7.使用var声明变量时，不能定义为泛型
        //var list2 = new ArrayList<String>();

        //8.使用var声明变量时，不能定义为方法引用
        //var fun = System.out::println;

        //9.使用var声明变量时，不能定义为lambda表达式
        //var fun1 = (x, y) -> x + y;

        //10.使用var声明变量时，不能定义为构造器引用
        //var fun2 = Employee::new;

        //11.使用var声明变量时，不能定义为数组引用
        //var fun3 = Employee[]::new;
    }
}
