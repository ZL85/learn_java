package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;

public class InputOutputStreamReaderWriterTest {
    //使用InputStreamReader实现字节流到字符流的转换
    @Test
    public void test1() {
        File file = new File("test_UTF-8.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;

        try {
            fis = new FileInputStream(file);
//            isr = new InputStreamReader(fis);//使用系统默认的字符集，正常输出
            isr = new InputStreamReader(fis, "UTF-8");//使用指定的字符集，正常输出
//            isr = new InputStreamReader(fis, "GBK");//使用指定的字符集，输出乱码

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("test_GBK.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;

        try {
            fis = new FileInputStream(file);
//            isr = new InputStreamReader(fis);//使用系统默认的字符集，输出乱码
//            isr = new InputStreamReader(fis, "UTF-8");//使用指定的字符集，输出乱码
            isr = new InputStreamReader(fis, "GBK");//使用指定的字符集，正常输出

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //将test-GBK.txt文件内容写出到UTF-8编码的文件test_UTF-8_1.txt
    @Test
    public void test3() {
        File file1 = new File("test_GBK.txt");
        File file2 = new File("test_UTF-8_1.txt");

        FileInputStream fis = null;
        InputStreamReader isr = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(file1);
            isr = new InputStreamReader(fis, "GBK");

            fos = new FileOutputStream(file2);
            osw = new OutputStreamWriter(fos, "UTF-8");

            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (osw != null) {
                osw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (fos != null) {
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (isr != null) {
                isr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (fis != null) {
                fis.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
