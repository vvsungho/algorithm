package doit.excercise.chap01;

import java.util.Scanner;

public class Median {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int median = a;
         
        if (a > b) {
            if (b > c) {
                median = b;
            } else {
                median = c;
            }
        } else if (a > c) {
            if (c > b) {
                median = c;
            }
        } else {
            if (b > c) {
                median = c;
            } else {
                median = b;
            }
        }

        System.out.println(median);
    }

}
