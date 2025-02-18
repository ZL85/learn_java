package com.learnjava_04;

public class TwoDimArray {
    public static void main(String[] args) {
        //数组的声明与初始化
        int[][] arr = new int[][]{{1, 2}, {3, 4}, {5, 6}};  // 3*2

        String[][] arr1 = new String[1][3];

        //访问数组元素
        System.out.println(arr[0][1]);  // 2
        System.out.println(arr[0]);  // [I@4eec7777

        //给数组元素赋值
        arr1[0][0] = "好好学习";
        arr1[0][1] = "天天向上";
        arr1[0][2] = "天天开心";

        //数组长度
        System.out.println(arr.length);
        System.out.println(arr[0].length);

        //遍历数组
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println(arr1[i][j]);
            }
        }

        //二维数组外层元素默认值是地址，内层元素参默认值照一维数组
    }
}
