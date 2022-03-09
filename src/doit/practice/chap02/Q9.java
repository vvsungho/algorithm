package doit.practice.chap02;

import java.util.Scanner;

public class Q9 {

    static int [][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("남은 일수를 구해보자.");
        System.out.print("년을 입력해주세요. : ");
        int y = scanner.nextInt();
        System.out.print("월을 입력해주세요. : ");
        int m = scanner.nextInt();
        System.out.print("일을 입력해주세요. : ");
        int d = scanner.nextInt();
        System.out.println("남은 일수: " + leftDayYear(y, m ,d));
    }

    public static int leftDayYear(int y, int m, int d) {
        int [] days = mdays[isLeap(y)];
        int answer = 0;

        for (int i = m - 1; i < days.length; i++) {
            answer += days[i];
        }

        answer-=d;

        return answer;
    }

    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }
}
