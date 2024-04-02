package com.learnjava_08;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Scanner;

public class ExceptionTest {
    @Test
    public void test1() {
        int[] arr = new int[10];
        System.out.println(arr[10]); //java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
    }

    @Test
    public void test2() {
//        String str = "hello";
//        str = null;
//        System.out.println(str.toString()); //java.lang.NullPointerException: Cannot invoke "String.toString()" because "str" is null

//        int[] arr1 = new int[10];
//        arr1 = null;
//        System.out.println(arr1[0]); //java.lang.NullPointerException: Cannot load from int array because "arr" is null

        int[][] arr2 = new int[10][];
        System.out.println(arr2[0][0]); //java.lang.NullPointerException: Cannot load from int array because "arr2[0]" is null
    }

    @Test
    public void test3() {
        Object obj = new String();
        String str = (String) obj;

        Date date = (Date) obj; //java.lang.ClassCastException: class java.lang.String cannot be cast to class java.util.Date (java.lang.String and java.util.Date are in module java.base of loader 'bootstrap')
    }

    @Test
    public void test4() {
        String str = "123";
        str = "abc";
        int i = Integer.parseInt(str);
        System.out.println(i); //java.lang.NumberFormatException: For input string: "abc"
    }

    @Test
    public void test5() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt(); //InputMismatchException
        System.out.println(i);
    }

    @Test
    public void test6() {
        int i = 10;
        System.out.println(i / 0); //java.lang.ArithmeticException: / by zero
    }

    @Test
    public void test7() {
//        Class cls = Class.forName("java.lang.String"); //java.lang.ClassNotFoundException
    }

    @Test
    public void test8() {
//        File file = new File("hello.txt");
//
//        FileInputStream fis = new FileInputStream(file); //java.io.FileNotFoundException
//
//        int data = fis.read(); //java.io.IOException
//        while (data != -1) {
//            System.out.println((char) data);
//            data = fis.read(); //java.io.IOException
//        }
//        fis.close(); //java.io.IOException
    }
}
