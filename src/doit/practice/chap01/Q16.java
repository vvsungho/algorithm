package doit.practice.chap01;

import java.util.Scanner;

/**
 * n단 피라미드 삼각형
 */
public class Q16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        triangle1(scanner.nextInt());
    }

    static void triangle1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i-1) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
