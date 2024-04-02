package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;

public class FileInputOutputStreamTest {
    //使用 FileInputStream 和 FileOutputStream 复制文件
    @Test
    public void test1() {
        //创建相关的File类的对象
        File file1 = new File("Wukong.png");
        File file2 = new File("Wukong_copy_0.png");

        //创建相关的字节流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        //数据的读入和写出操作
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] buffer = new byte[1024];
            int len; //记录每次读入到 buffer 中的字节的个数
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭流
            try {
                assert fis != null;
                fis.close();
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //复制hello.txt文件为hello3.txt
    @Test
    public void test2() {
        File file1 = new File("hello.txt");
        File file2 = new File("hello3.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            assert fis != null;
            fis.close();
            assert fos != null;
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //读取hello.txt文件输出到控制台上
    @Test
    public void test4() {
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[5]; //输出乱码
//            byte[] buffer = new byte[20]; //正常输出
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            assert fis != null;
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
