package doit.practice.chap01;

import java.util.Scanner;

public class 별찍기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        drawTriangle1(number);
        drawTriangle2(number);
        drawTriangle3(number);
        drawTriangle4(number);
        drawTriangle5(number);
        drawTriangle6(number);
    }

    // 왼쪽 아래 직각삼각형
    public static void drawTriangle1(int n) {
        System.out.println("왼쪽 아래 직각삼각형");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // 왼쪽 위 직각삼각형
    public static void drawTriangle2(int n) {
        System.out.println("왼쪽 위 직각삼각형");
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // 오른쪽 아래 직각삼각형
    public static void drawTriangle3(int n) {
        System.out.println("오른쪽 아래 직각삼각형");
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // 오른쪽 위 직각삼각형
    public static void drawTriangle4(int n) {
        System.out.println("오른쪽 위 직각삼각형");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // 피라미드 삼각형
    public static void drawTriangle5(int n) {
        System.out.println("피라미드 삼각형");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= ((i-1) * 2) + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    // 피라미드 역삼각형
    public static void drawTriangle6(int n) {
        System.out.println("피라미드 역삼각형");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (n-i+1) * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
