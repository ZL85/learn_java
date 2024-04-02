package learnjava_17;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceTest {
    //构造器引用
    //类::new
    @Test
    public void test1() {
        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup1.get());

        Function<Integer, Employee> func1 = Employee::new;
        System.out.println(func1.apply(21));

        BiFunction<String, Integer, Employee> func2 = Employee::new;
        System.out.println(func2.apply("King", 18));
    }
}
