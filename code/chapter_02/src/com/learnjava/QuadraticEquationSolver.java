package com.learnjava;

import java.util.Scanner;

public class QuadraticEquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一元二次方程的三个系数（a, b, c）：");
        System.out.print("a = ");
        double a = scanner.nextDouble();
        System.out.print("b = ");
        double b = scanner.nextDouble();
        System.out.print("c = ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("方程的两个实根为：");
            System.out.println("x1 = " + root1);
            System.out.println("x2 = " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("方程的唯一实根为：");
            System.out.println("x = " + root);
        } else {
            System.out.println("方程没有实根，存在虚根。");
        }

        scanner.close();
    }
}
