package learnjava_17;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchTest {
    //try catch新特性
    @Test
    public void test1() {
        //try catch 处理文件异常jdk7之前的写法
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("hello.txt");
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {
        //try catch 处理文件异常jdk7的写法
        try (FileInputStream fis = new FileInputStream("hello.txt")) {
            int data = fis.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
