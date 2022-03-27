package inflearn.part04.매출액의종류;

/**
 * https://cote.inflearn.com/contest/10/problem/04-03
 * 설명
 *
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 *
 * 각 구간별로 구하라고 했습니다.
 *
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 *
 * 20 12 20 10 23 17 10
 *
 * 각 연속 4일간의 구간의 매출종류는
 *
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 *
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 *
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 *
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 *
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
 *
 * 두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
 *
 *
 * 출력
 * 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 7 4
 * 20 12 20 10 23 17 10
 * 예시 출력 1
 *
 * 3 4 4 3
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i  < n; i++) {
            arr[i] = kb.nextInt();
        }
        main.solution(n, m, arr);
    }

    public void solution(int n, int m, int[] arr) {
        int lt = 0, rt;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < m - 1; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        }

        for (rt = m - 1; rt < n; rt++) {
            hashMap.put(arr[rt], hashMap.getOrDefault(arr[rt], 0) + 1);

            // m칸의 hashmap size를 출력.
            System.out.print(hashMap.size() + " ");

            // 1칸 지나왔으므로 가장 좌측에 있는 map값을 줄여줌.
            hashMap.put(arr[lt], hashMap.get(arr[lt]) - 1);

            // 0이되면 map에서 삭제함. 
            if (hashMap.get(arr[lt]) == 0) hashMap.remove(arr[lt]);
            lt++;
        }

    }

}
