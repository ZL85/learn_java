package learnjava_17;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {
    //对象::实例方法名
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Hello Lambda!");

        System.out.println("-".repeat(100));

        Consumer<String> con2 = System.out::println;
        con2.accept("Hello Lambda!");

        Supplier<String> sup = () -> new String();
        String str = sup.get();
        System.out.println(str);

        Supplier<String> sup2 = String::new;
        String str2 = sup2.get();
        System.out.println(str2);
    }

    //类::静态方法名
    @Test
    public void test2() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 21));

        System.out.println("-".repeat(100));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 21));
    }

    //类::实例方法名
    @Test
    public void test3() {
        Function<Double, Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };
        System.out.println(fun1.apply(12.3));

        System.out.println("-".repeat(100));

        Function<Double, Long> fun2 = Math::round;
        System.out.println(fun2.apply(12.3));
    }

    @Test
    public void test4() {
        Comparator<String> com1 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com1.compare("abc", "abd"));

        System.out.println("-".repeat(100));

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abd"));
    }

    @Test
    public void test5() {
        BiPredicate<String, String> bp1 = (s1, s2) -> s1.equals(s2);
        System.out.println(bp1.test("abc", "abc"));

        System.out.println("-".repeat(100));

        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("abc", "abc"));
    }

    @Test
    public void test6() {
        Function<Employee, String> fun1 = e -> e.getName();
        System.out.println(fun1.apply(new Employee("Tom", 12)));
        System.out.println("-".repeat(100));

        Function<Employee, String> fun2 = Employee::getName;
        System.out.println(fun2.apply(new Employee("Tom", 12)));
    }
}
