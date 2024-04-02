package learnjava_17;

import org.junit.jupiter.api.Test;

public class TextBlockTest {
    @Test
    public void test1() {
        //文本块的使用
        String str1 = """
                hello,
                world!
                """;
        System.out.println(str1);
    }
}
