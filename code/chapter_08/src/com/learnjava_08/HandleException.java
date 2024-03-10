package com.learnjava_08;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HandleException {
    @Test
    public void test1() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
        }

        System.out.println("异常处理结束，继续执行代码");
    }

    @Test
    public void test2() {
        try {
            String str = "123";
            str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
            e.printStackTrace(); //推荐
//            System.out.println(e.getMessage());
        }
    }

    @Test
    public void test3() {
        try {
            File file = new File("hello.txt");

            FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException

            int data = fis.read(); //java.io.IOException
            while (data != -1) {
                System.out.println((char) data);
                data = fis.read(); //java.io.IOException
            }
            fis.close(); //java.io.IOException
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("读取数据结束");
    }

    public void test5() {
        try {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt(); //InputMismatchException
            System.out.println(i);
        } catch (InputMismatchException e) {
            System.out.println("出现InputMismatchException");
            System.out.println(10 / 0); //在catch中存在异常
        } finally {
            System.out.println("异常处理结束，继续执行代码");

        }

    }
}
