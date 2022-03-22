package inflearn.part03.연속부분수열;

/**
 * https://cote.inflearn.com/contest/10/problem/03-04
 * 4. 연속 부분수열
 * 설명
 *
 * N개의 수로 이루어진 수열이 주어집니다.
 *
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 *
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 *
 * 1 2 1 3 1 1 1 2
 *
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 *
 * 입력
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 *
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 *
 * 출력
 * 첫째 줄에 경우의 수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 8 6
 * 1 2 1 3 1 1 1 2
 * 예시 출력 1
 *
 * 3
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();

        int n = kb.nextInt();
        int m = kb.nextInt();

        int [] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(main.solution(n, m, arr));
    }

    /**
     * 1. rt가 가리키고 있는 배열 값을 sum에 더해준다.
     *
     * 2. sum과 m이 같을 경우 경우의 수를 증감한다.
     *
     * 3. sum이 크거나 같을 경우 배열을 지나왔던 값을 sum에서 빼준고 lt를 증감한다. 단, 지나왔던 값을 하나 빼도 현재의 sum이 m보다 클 수 있으니 while문을 사용하여 sum이 m보다 작아질 때 까지 반복하여 수행해야한다.
     * @param n
     * @param m
     * @param arr
     * @return
     */
    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = 0, rt, sum = 0;

        for (rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) answer++;
            }
        }

        return answer;
    }

}

