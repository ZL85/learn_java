package learnjava_14;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedReaderWriterTest {
    //使用BufferedReader的readLine()方法读文件
    @Test
    public void test1() {
        File file = new File("凡人修仙传.txt");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //使用BufferedReader的read()方法读文件
    @Test
    public void test2() {
        File file = new File("凡人修仙传.txt");

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            char[] cbuf = new char[5];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //使用BufferedWriter的write()方法写文件
    @Test
    public void test3() {
        File file = new File("凡人修仙传1.txt");

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("凡人修仙传");
            writer.newLine();
            writer.write("凡人修仙传");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //使用BufferedReader和BufferedWriter复制文件
    @Test
    public void test4() {
        File srcFile = new File("凡人修仙传.txt");
        File destFile = new File("凡人修仙传2.txt");

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(srcFile));
            bw = new BufferedWriter(new FileWriter(destFile));

            char[] cbuf = new char[1024];
            int len;
            while ((len = br.read(cbuf)) != -1) {
                bw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
