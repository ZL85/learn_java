package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileReaderWriterTest {
    @Test
    public void test1() {
        // 1. 创建File类的对象
        File file1 = new File("hello.txt");

        FileReader fr = null;
        try {
            fr = new FileReader(file1);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // read(): 返回读入的一个字符。如果达到文件末尾，返回-1
//        int data = fr.read();
//        while (data != -1) {
//            System.out.print((char) data);
//            data = fr.read();
//        }
        int data;
        while (true) {
            try {
                if ((data = fr.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.print((char) data);
        }

        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file1);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void test3() {
        File file1 = new File("hello.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file1);
            File file2 = new File("hello2.txt");
            fw = new FileWriter(file2);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                assert fw != null;
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
