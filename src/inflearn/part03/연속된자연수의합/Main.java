package inflearn.part03.연속된자연수의합;

/**
 * https://cote.inflearn.com/contest/10/problem/03-05
 * 5. 연속된 자연수의 합
 * 설명
 *
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 *
 * 만약 N=15이면
 *
 * 7+8=15
 *
 * 4+5+6=15
 *
 * 1+2+3+4+5=15
 *
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 *
 * 입력
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 총 경우수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 15
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
        System.out.println(main.solution(n));
        System.out.println(main.solution2(n));
    }

    public int solution(int n) {
        int answer = 0, sum = 0, lt = 0, rt;
        int[] arr = new int[n];

        // 연속된 자연수의 합이 n이 되어야 하므로, 두 조합의 수중 가장 큰 수는 8이다. => 7+8
        // 그러므로 n을 2로나눈 몫의 +1 까지만 자연수의 조합을 확인하면 된다.
        for (int i = 0; i < n/2+1; i++) {
            arr[i] = i + 1;
        }

        // rt를 하나씩 증감하며 합계가 15가 되는지 확인한다.
        for (rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum==n) {
                answer++;
            }

            // sum이 같거나 커질경우 지나왔던 lt를 차감한다.
            while (sum >= n) {
                sum-=arr[lt++];
                if (sum==n) {
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * 몫으로 구하는 방법.
     *
     *  n에서 빠지는 값과 cnt의 값을 n에서 빼고, 그 뺀 값을 cnt와 나누어 떨어지면 정답으로 처리하는 방식.
     *      1.
     *      *  15-1-2 = 12
     *      *  12 / 2 = 6 => answer
     *      *  1       2
     *      *  6       6
     *      *  ===========
     *      *  7        8
     *
     *      2.
     *      *  12-3 = 9
     *      *  9 / 3 = 3 => answer
     *      *  1        2       3
     *      *  3        3       3
     *      *  =====================
     *      *  4        5       6
     *
     *      3.
     *      *  9-4= 5
     *      *  5 / 4 = 1...1 => answer x
     *      *
     *      4.
     *      *  5-5 = 0
     *      *  0 / 5 = 0 => answer
     *      *  1        2       3       4       5
     *      *  0        0       0       0       0
     *      *  ======================================
     *      *  1        2       3       4       5
     * @param n
     * @return
     */
    public int solution2(int n) {
        // 연속된 숫자 1 (n에서 빠지는 값, n--), 2 (cnt)를 초기값으로 설정해야한다. => 암기
        
        int answer = 0;

        int cnt = 1;

        // 연속된 자연수여야 하므로 1을 빼어, 2개 이상의 자연수(14 + 1) 이도록 한다.
        n--;
        while (n > 0) {
            n -= ++cnt;

            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }

}
