package doit.practice.chap02;

import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scanner = new Scanner(System.in);
        int 재시도여부 = 0;
        int 변환하고자하는숫자 = 0;
        int 진수 = 0;
        char[] 진수저장배열 = new char[32];
        int 변환된진수자릿수 = 0;

        do {
            System.out.println("10진수를 기수 변환 합니다.");
            do {
                System.out.print("변환하는 음이 아닌 정수: ");
                변환하고자하는숫자 = scanner.nextInt();
            } while (변환하고자하는숫자 < 0);

            do {
                System.out.println("변환하고자하는숫자: " + 변환하고자하는숫자);
                System.out.print("어떤 진수로 변환할까요? (2~36): ");
                진수 = scanner.nextInt();

                변환된진수자릿수 = cardConvert(변환하고자하는숫자, 진수, 진수저장배열);

                System.out.print(진수 + "진수로는 ");
                for (int i = 변환된진수자릿수 - 1; i >= 0; i--) {
                    System.out.print(진수저장배열[i]);
                }
                System.out.println(" 입니다.");
            } while (false);

            System.out.print("한 번 더 할까요? (1.예 / 0.아니오): ");
            재시도여부 = scanner.nextInt();
            System.out.println(재시도여부);

        } while (재시도여부 == 1);

    }

    public static int cardConvert(int 변환하고자하는숫자, int 진수, char[] 진수저장배열) {
        char [] pattern = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'N', 'M', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        int index = 0;

        do {
            진수저장배열[index++] = pattern[변환하고자하는숫자%진수];
            변환하고자하는숫자/=진수;
        } while (변환하고자하는숫자 != 0);

        return index;
    }
}
