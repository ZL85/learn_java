package learnjava_17;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class ArraryReferenceTest {
    //数组引用
    //数组名[]::new
    @Test
    public void test1() {
        Function<Integer, Employee[]> fun1 = length -> new Employee[length];
        Employee[] employees1 = fun1.apply(5);
        System.out.println(employees1.length);

        Function<Integer, Employee[]> fun2 = Employee[]::new;
        Employee[] employees2 = fun2.apply(10);
        System.out.println(employees2.length);
    }
}
