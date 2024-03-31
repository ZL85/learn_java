package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;

public class CopyFileTest {

    @Test
    public void spendTime() {
        long start = System.currentTimeMillis();
        String source = "void.mp3";
        String destination = "void_copy_0.mp3";
//        CopyFileWithFileInputOutputStream(source, destination);// 1.5s
        CopyFileWithBufferedInputOutputStream(source, destination);// 0.1s
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为：" + (end - start) + "毫秒");
    }


    public void CopyFileWithFileInputOutputStream(String source, String destination) {
        //创建相关的File类的对象
        File file1 = new File(source);
        File file2 = new File(destination);

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
        }

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

    public void CopyFileWithBufferedInputOutputStream(String source, String destination) {
        //创建相关的File类的对象
        File file1 = new File(source);
        File file2 = new File(destination);

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
