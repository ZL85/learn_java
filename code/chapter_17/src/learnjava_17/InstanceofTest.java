package learnjava_17;

import org.junit.jupiter.api.Test;

public class InstanceofTest {
    //instanceof新特性
    @Test
    public void test1() {
        //jdk14的instanceof新特性
        Object obj = "hello";
        if (obj instanceof String str) {
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("obj不是String类型");
        }
    }

    @Test
    public void test2() {
        //jdk15的instanceof新特性
        Object obj = "hello";
        if (obj instanceof String str && str.length() > 5) {
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("obj不是String类型或者长度小于等于5");
        }
    }
}
