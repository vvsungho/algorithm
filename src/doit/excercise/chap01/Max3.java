package doit.excercise.chap01;

import java.util.Scanner;

public class Max3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a값: ");
        int a = scanner.nextInt();
        System.out.println("b값: ");
        int b = scanner.nextInt();
        System.out.println("c값: ");
        int c = scanner.nextInt();

        int max = a;

        if (a < b) {
            max = b;
        } else if (b < c) {
            max = c;
        }

        System.out.println("최댓값은[ " + max + "]입니다.");
    }



}
