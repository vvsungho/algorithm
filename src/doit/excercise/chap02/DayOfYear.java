package doit.excercise.chap02;

import java.util.Scanner;

public class DayOfYear {

    static int [][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("날짜를 입력해주세요.");
        System.out.print("년을 입력해주세요.");
        int y = scanner.nextInt();
        System.out.print("월을 입력해주세요.");
        int m = scanner.nextInt();
        System.out.print("일을 입력해주세요.");
        int d = scanner.nextInt();

        System.out.println("지난 일수: " + leftDayOfYear(y, m, d));
    }

    public static int leftDayOfYear(int y, int m, int d) {
        int day = d;

        int [] days = mdays[isLeap(y)];

        for (int i = 0; i < m-1; i++) {
            day += days[i];
        }

        return day;
    }

    public static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

}
