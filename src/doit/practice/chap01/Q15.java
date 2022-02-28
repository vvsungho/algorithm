package doit.practice.chap01;

import java.util.Scanner;

public class Q15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      triangle1(scanner.nextInt()); // 왼쪽아래가 직각인 이등변 삼각형 출력
//      triangle2(scanner.nextInt()); // 왼쪽 위가 직각인 이등변 삼각형 출력
//      triangle3(scanner.nextInt()); // 오른쪽 위가 직각인 이등변 삼각형 출력
      triangle4(scanner.nextInt()); // 오른쪽 아래가 직각인 이등변 삼각형 출력
    }

    /**
     * 왼쪽 아래가 직각인 이등변 삼각형 출력
     */
    static void triangle1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 왼쪽 위가 직각인 이등변 삼각형 출력
     */
    static void triangle2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 위가 직각인 이등변 삼각형 출력
     */
    static void triangle3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i<= j ? "*" : " ");
            }
            System.out.println();
        }
    }

    /**
     * 오른쪽 아래가 직각인 이등변 삼각형 출력
     */
    static void triangle4(int n) {
        //        for (int i = 1; i <= n; i++) {
        //            for (int j = n; j >= 1; j--) {
        //                if (i >= j) {
        //                    System.out.print("*");
        //                } else {
        //                    System.out.print(" ");
        //                }
        //            }
        //            System.out.println();
        //        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i+j > n ? "*" : " ");
            }
            System.out.println();
        }
    }

}
