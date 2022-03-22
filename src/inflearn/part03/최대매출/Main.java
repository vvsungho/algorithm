package inflearn.part03.최대매출;

/**
 * https://cote.inflearn.com/contest/10/problem/03-03
 * 3. 최대 매출
 * 설명
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
 *
 * 만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면
 *
 * 12 1511 20 2510 20 19 13 15
 *
 * 연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.
 *
 * 여러분이 현수를 도와주세요.
 *
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 *
 * 출력
 * 첫 줄에 최대 매출액을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 10 3
 * 12 15 11 20 25 10 20 19 13 15
 * 예시 출력 1
 *
 * 56
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();

        int n = kb.nextInt();
        int m = kb.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(main.solution(n, m, arr));
    }

    // sliding windows 방식
    // i-m ~ i번까지 배열의 합을 구하고 오른쪽으로 배열을 한칸씩 밀며 최댓값을 구하는 방식.
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int sum = 0;
        // 초기값 셋팅, 0번 부터 m번까지 합을 미리 구해놓는다.
        for (int i = 0; i < m; i++) {
            sum+=arr[i];
        }

        answer = sum;
        // i-m번의 값은 빼고, i번째 값을 더하면, 한칸씩 앞당기며 합을 구한 것과 같다.
        // 2중 for문보다 속도가 훨씬 빠르다.
        for (int i = m; i < n; i++) {
            sum += (arr[i] - arr[i-m]);
            // 최댓값 비교
            answer = Math.max(answer, sum);
        }
        return answer;
    }

}
