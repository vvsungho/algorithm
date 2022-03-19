package inflearn.part02.등수구하기;

/**
 * https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/lecture/72725?tab=curriculum&volume=1.00
 * 8. 등수구하기
 * 설명
 *
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 *
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 *
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 *
 * 입력
 * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 입력된 순서대로 등수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 87 89 92 100 76
 * 예시 출력 1
 *
 * 4 3 2 1 5
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();
        int n = kb.nextInt();
        int[] arr = new int [n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int[] answer = m.solution(n, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        int index = 0;
        for (int i : arr) {
            int cnt = 1;
            for (int j : arr) {
                cnt = i < j ? ++cnt : cnt;
            }
            answer[index++] = cnt;
        }

        return answer;
    }

}
