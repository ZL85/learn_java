package learnjava_12;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Predicate;

public class GenericsTest {
    //List中不使用泛型
    @Test
    public void test1() {
        List list = new ArrayList();
        //假设指向添加整型数据
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //类型不安全，因为add()的参数是Object类型，意味着任何类型的对象都可以添加成功。
        list.add("hello");

        for (Object o : list) {
            //需要使用强转操作，繁琐，还有可能导致CLassCastException异常。
            Integer i = (Integer) o;
            int score = i;
            System.out.println(score);
        }
    }

    //List中使用泛型
    @Test
    public void test2() {
        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

//        list.add("hello"); //编译时期就会报错

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            int score = i;
            System.out.println(score);
        }
    }

    //Map中使用泛型
    @Test
    public void test3() {
//        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //jdk7新特性：类型推断
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom", 87);
        map.put("Jerry", 90);
        map.put("Jack", 78);
        map.put("Rose", 99);

//        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();

        //jdk10新特性：局部变量类型推断
        var entrySet = map.entrySet();
        var iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    //自然排序：按照name排序
    @Test
    public void test4() {
        TreeSet<Employee> set = new TreeSet<>();

        set.add(new Employee("Tom", 23, new MyDate(1998, 5, 23)));
        set.add(new Employee("Jerry", 22, new MyDate(1999, 6, 5)));
        set.add(new Employee("Jack", 24, new MyDate(1997, 7, 26)));
        set.add(new Employee("Rose", 21, new MyDate(2000, 8, 26)));
        set.add(new Employee("Robin", 21, new MyDate(2001, 6, 16)));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }


    //定制排序：按照生日先后进行排序
    @Test
    public void test5() {
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int minusYear = o1.getBirthday().getYear() - o2.getBirthday().getYear();
                if (minusYear != 0) {
                    return minusYear;
                }

                int minusMonth = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                if (minusMonth != 0) {
                    return minusMonth;
                }

                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        };

        TreeSet<Employee> set = new TreeSet<>(comparator);

        set.add(new Employee("Tom", 23, new MyDate(1998, 5, 23)));
        set.add(new Employee("Jerry", 22, new MyDate(1999, 6, 5)));
        set.add(new Employee("Jack", 24, new MyDate(1997, 7, 26)));
        set.add(new Employee("Rose", 21, new MyDate(2000, 8, 26)));
        set.add(new Employee("Robin", 21, new MyDate(2001, 6, 16)));

        for (Employee employee : set) {
            System.out.println(employee);
        }
    }

    @Test
    public void test6() {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int random = (int) (Math.random() * (99 - 0 + 1));
            list.add(random);
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

        //使用removeIf()删除其中偶数，为Predicate接口指定泛型<Integer>
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });

        System.out.println();

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test7() {
        //未指定泛型参数类型按照Object类型处理
        Order order1 = new Order();
        System.out.println(order1.getT());


        //泛型参数在指明时，是不可以使用基本数据类型的，但是可以使用包装类替代基本数据类型
//        Order<int> order = new Order<>(); //错误
//        Order<Integer> order2 = new Order<>(); //正确
        Order<String> order2 = new Order<>();
        order2.setT("order2");
        order2.setOrderId(2);
        System.out.println(order2.getT());
    }

    //测试Order的子类
    @Test
    public void test8() {
        //SubOrder1不是泛型类，所以在实例化时不需要指明泛型类型
        SubOrder1 subOrder1 = new SubOrder1();

        //SubOrder2不是泛型类，所以在实例化时不需要指明泛型类型
        SubOrder2 subOrder2 = new SubOrder2();

        //SubOrder3是泛型类，所以在实例化时需要指明泛型类型
        SubOrder3<String> subOrder3 = new SubOrder3<>();
        subOrder3.show("subOrder3");

        //SubOrder4是泛型类，所以在实例化时需要指明泛型类型
        SubOrder4<String> subOrder4 = new SubOrder4<>();
        Integer t4 = subOrder4.getT();
        String e4 = subOrder4.getE();

        //SubOrder5是泛型类，所以在实例化时需要指明泛型类型
        SubOrder5<String, Integer> subOrder5 = new SubOrder5<>();
        String t5 = subOrder5.getT();
        Integer e5 = subOrder5.getE();
    }

    @Test
    public void test9() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        ArrayList<Integer> list = order.copyElements(arr);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test10() {
        Object obj = null;
        String str = "hello";

        obj = str; //基于继承性的多态的使用

        Object[] o_arr = null;
        String[] s_arr = new String[]{"Tom", "Jerry", "Jack"};

        o_arr = s_arr; //基于继承性的多态的使用

        ArrayList<Object> list1 = null;
        ArrayList<String> list2 = null;

//        list1 = list2; //编译不通过
    }

    @Test
    public void test11() {
        List<String> list1 = null;
        ArrayList<String> list2 = null;

        list1 = list2; //编译通过
        list1.add("hello");
    }

    //通配符的使用
    @Test
    public void test12() {
        List<?> list = null;

        List<Object> list1 = null;
        List<String> list2 = null;

        list = list1;
        list = list2;

        method(list1);
        method(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");

        list = list3;

        //添加(写入)：对于List<?>就不能向其内部添加数据
//        list.add("CC");
//        list.add(123);
        list.add(null); //只能添加null

        //获取(读取)：允许读取数据，读取的数据类型为Object
        Object o = list.get(0);
        System.out.println(o);
    }

    public void method(List<?> list) {
    }

    @Test
    public void test13() {
        List<? extends Father> list1 = null;

        List<Object> list2 = null;
        List<Father> list3 = null;
        List<Son> list4 = null;

//        list1 = list2; //编译不通过
        list1 = list3;
        list1 = list4;

        //读取数据：
        list1 = list3;
        Father father = list1.get(0);
        //编译不通过
//        Son son = list1.get(0);

        //编译不通过
//        list1.add(new Father());

        //编译不通过
//        list1.add(new Son());

        //编译不通过
//        list1.add(new Object());

        list1.add(null);
    }

    @Test
    public void test14() {
        List<? super Father> list1 = null;


        List<Object> list2 = null;
        List<Father> list3 = null;
        List<Son> list4 = null;

        list1 = list2;
        list1 = list3;
//        list1 = list4; //编译不通过

        //添加
        list1.add(new Father());
        list1.add(new Son());

        //获取
        Object object = list1.get(0);
    }
}
