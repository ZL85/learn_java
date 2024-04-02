package learnjava_17;

import org.junit.jupiter.api.Test;

import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    //创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        //default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream() : 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    //创建Stream方式二：通过数组
    @Test
    public void test2() {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> stream1 = Arrays.stream(arr1);

        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        //调用Arrays类的stream()方法，不是Arrays类的静态方法
        IntStream stream2 = Arrays.stream(arr2);
    }

    //创建Stream方式二：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

    //中间操作一：筛选与切片
    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p)：接收Lambda，从流中排除某些元素
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();

        //limit(n)：截断流，使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);

        System.out.println();

        //skip(n)：跳过元素，返回一个扔掉了前n个元素的流
        employees.stream().skip(3).forEach(System.out::println);

        System.out.println();

        //distinct()：筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        employees.add(new Employee("刘强东", 40, 8000));
        employees.add(new Employee("刘强东", 40, 8000));
        employees.add(new Employee("刘强东", 40, 8000));
        employees.add(new Employee("刘强东", 40, 8000));
        employees.add(new Employee("刘强东", 40, 8000));
        employees.stream().distinct().forEach(System.out::println);
    }

    //中间操作二：映射
    @Test
    public void test5() {
        //map(Function f)：接收一个函数作为参数，将元素转换成其他形式或提取信息
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
//        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        //练习1：获取员工姓名长度大于3的员工
        List<Employee> employees1 = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees1.stream().filter(e -> e.getName().length() > 3);
        employeeStream.forEach(System.out::println);


        //练习1：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees2 = EmployeeData.getEmployees();
//        Stream<String> nameStream = employees2.stream().map(Employee::getName);
//        nameStream.filter(name -> name.length() > 3).forEach(System.out::println);
        employees2.stream().map(Employee::getName).filter(name -> name.length() > 3).forEach(System.out::println);


        //flatMap(Function f)：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        Stream<Stream<Character>> stream = list.stream().map(StreamTest::fromStringToStream);
        stream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(StreamTest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    private static Stream<Character> fromStringToStream(String s) {
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //中间操作三：排序
    @Test
    public void test6() {
        //sorted()：自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 23);
        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        //sorted(Comparator com)：定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageValue = Integer.compare(e1.getAge(), e2.getAge());
            if (ageValue != 0) {
                return ageValue;
            } else {
                return Double.compare(e1.getSalary(), e2.getSalary());
            }
        }).forEach(System.out::println);
    }

    //终止操作一：匹配与查找
    @Test
    public void test7() {
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p)：检查是否匹配所有元素
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        System.out.println();

        //anyMatch(Predicate p)：检查是否至少匹配一个元素
        boolean anyMatch = employees.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(anyMatch);

        System.out.println();

        //noneMatch(Predicate p)：检查是否没有匹配所有元素
        boolean noneMatch = employees.stream().noneMatch(e -> e.getAge() > 18);
        System.out.println(noneMatch);

        System.out.println();

        //findFirst()：返回第一个元素
        Employee employee = employees.stream().findFirst().get();
        System.out.println(employee);

        System.out.println();

        //findAny()：返回当前流中的任意元素
        Employee employee1 = employees.parallelStream().findAny().get();
        System.out.println(employee1);

        System.out.println();

        //count()：返回流中元素的总个数
        long count = employees.stream().count();
        System.out.println(count);

        System.out.println();

        //max(Comparator c)：返回流中最大值
        //使用自然排序
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        double maxSalary = salaryStream.max(Double::compare).get();
        System.out.println(maxSalary);

        System.out.println();

        //使用定制排序
        Stream<Employee> employeeStream = employees.stream();
        Employee employee2 = employeeStream.max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        System.out.println(employee2);

        System.out.println();

        //min(Comparator c)：返回流中最小值
        //使用自然排序
        Stream<Double> salaryStream1 = employees.stream().map(Employee::getSalary);
        double minSalary = salaryStream1.min(Double::compare).get();
        System.out.println(minSalary);

        System.out.println();

        //使用定制排序
        Stream<Employee> employeeStream1 = employees.stream();
        Employee employee3 = employeeStream1.min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).get();
        System.out.println(employee3);

        System.out.println();

        //forEach(Consumer c)：内部迭代
        employees.stream().forEach(System.out::println);
    }

    //终止操作二：归约
    @Test
    public void test8() {
        //reduce(T identity, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回T
        //练习1：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println();

        //reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        System.out.println(sumSalary.get());
    }

    //终止操作三：收集
    @Test
    public void test9() {
        //collect(Collector c)：将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> employeeStream = employees.stream().filter(e -> e.getSalary() > 6000);
        List<Employee> list = employeeStream.collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println();

        Stream<Employee> employeeStream1 = employees.stream().filter(e -> e.getSalary() > 6000);
        Set<Employee> set = employeeStream1.collect(Collectors.toSet());
        set.forEach(System.out::println);
    }
}
