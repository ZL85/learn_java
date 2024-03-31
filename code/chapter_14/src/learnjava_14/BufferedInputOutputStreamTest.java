package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;


public class BufferedInputOutputStreamTest {
    //使用 BufferedInputStream 和 BufferedOutputStream 复制非文本文件
    @Test
    public void test1() {
        //创建相关的File类的对象
        File file1 = new File("Wukong.png");
        File file2 = new File("Wukong_copy_1.png");

        //创建相关的字节流
        FileInputStream fis = null;
        FileOutputStream fos = null;

        //创建BufferedInputStream 和 BufferedOutputStream
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        //数据的读入和写出操作
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len; //记录每次读入到 buffer 中的字节的个数
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //关闭流
        try {
            assert bis != null;
            bis.close();
            assert bos != null;
            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
