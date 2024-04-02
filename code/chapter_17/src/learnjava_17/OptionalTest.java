package learnjava_17;

import org.junit.jupiter.api.Test;

public class OptionalTest {
    //Optional新特性
    @Test
    public void test1() {
        //jdk8之前的Optional
        String str = "hello";
        if (str != null) {
            System.out.println(str.toUpperCase());
        } else {
            System.out.println("str为null");
        }
    }

    @Test
    public void test2() {
        //jdk8的Optional
        String str = "hello";
        System.out.println(java.util.Optional.ofNullable(str).map(String::toUpperCase).orElse("str为null"));
    }

    @Test
    public void test3() {
        //jdk9的Optional
        String str = "hello";
        System.out.println(java.util.Optional.ofNullable(str).or(() -> java.util.Optional.of("world")).map(String::toUpperCase).get());
    }

    @Test
    public void test4() {
        //jdk10的Optional
        String str = "hello";
        System.out.println(java.util.Optional.ofNullable(str).or(() -> java.util.Optional.of("world")).map(String::toUpperCase).orElseThrow());
    }
}
