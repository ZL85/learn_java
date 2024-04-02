package learnjava_17;

import org.junit.jupiter.api.Test;

public class SwitchTest {
    //switch新特性
    @Test
    public void test1() {
        //jdk12之前的switch
        int num = 2;
        switch (num) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
        }
    }

    @Test
    public void test2() {
        //jdk12的switch
        int num = 2;
        switch (num) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            default -> System.out.println("default");
        }
    }

    @Test
    public void test3() {
        //jdk14的switch
        int num = 2;
        String result = switch (num) {
            case 1 -> "1";
            case 2 -> "2";
            default -> "default";
        };
    }

    @Test
    public void test4() {
        //jdk14的switch
        int num = 2;
        String result = switch (num) {
            case 1 -> {
                System.out.println("1");
                yield "1";
            }
            case 2 -> {
                System.out.println("2");
                yield "2";
            }
            default -> {
                System.out.println("default");
                yield "default";
            }
        };
    }
}
