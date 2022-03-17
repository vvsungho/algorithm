package inflearn.part02.큰수출력하기;

/**
 * https://cote.inflearn.com/contest/10/problem/02-01
 * 1. 큰 수 출력하기
 * 설명
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 *
 * (첫 번째 수는 무조건 출력한다)
 *
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 6
 * 7 3 9 5 6 12
 * 예시 출력 1
 *
 * 7 9 6 12
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();

        int n = kb.nextInt();
        int [] arr = new int[n];

        for (int i = 0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int i : m.solution(n, arr)) {
            System.out.print(i + " ");
        }
    }

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i-1] < arr[i]) answer.add(arr[i]);
        }
        return answer;
    }
}
