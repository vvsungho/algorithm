package inflearn.part02.소수;

/**
 * https://cote.inflearn.com/contest/10/problem/02-05
 * 5. 소수(에라토스테네스 체)
 * 설명
 *
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 소수의 개수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 20
 * 예시 출력 1
 *
 * 8
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();

        System.out.println(m.solution(kb.nextInt()));
    }

    // 자연수 n에 해당하는 길이 + 1 만큼 int 배열을 생성해준다. => arr[2] = 0, arr[3] =0
    // 각 자연수 index에 해당하는 배열의 값이 0일 경우 소수로 인식하여 문제해결 할 예정.
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];

        // 1은 소수가 아니므로 2부터 체크
        for (int i = 2; i<= n; i++) {
            // 값이 0이면 소수라고 인지하고 소수로 카운트한다.
            if (arr[i] == 0) {
                answer++;
                // 인덱스의 배수에 해당하는 값들은 공배수이므로 소수가 아니다.
                // i의 배수인 것들을 모두 값을 1을 채워준다.
                // i = 2일 때 i를 2씩 더하면 2의 배수를 체크할 수 있다.
                // i = 3일 때 i를 3씩 더하면 3의 배수를 체크할 수 있다.
                for (int j = i; j <= n; j+=i) {
                    arr[j] = 1;
                }
            }
        }

        return answer;
    }

}
