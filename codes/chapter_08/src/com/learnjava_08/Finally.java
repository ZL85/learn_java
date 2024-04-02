package com.learnjava_08;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Finally {
    //    public static void main(String[] args) {
//        int result = test("8");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//        }
//    }

//    public static void main(String[] args) {
//        int result = test("a");
//        System.out.println(result);
//    }
//
//    public static int test(String str) {
//        try {
//            Integer.parseInt(str);
//            return 1;
//        } catch (NumberFormatException e) {
//            return -1;
//        } finally {
//            System.out.println("test结束");
//            return 0;
//        }
//    }

    public static void main(String[] args) {
        int result = test(10);
        System.out.println(result);
    }

    public static int test(int i) {
        try {
            return i;
        } catch (NumberFormatException e) {
            return i--;
        } finally {
            System.out.println("test结束");
//            return ++i; //11
            ++i; //10
        }
    }

    @Test
    public void test1() {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");

            fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //将流资源的关闭操作放在finally中
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("读取数据结束");
    }
}
