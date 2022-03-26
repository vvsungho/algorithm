package inflearn.part03.최대길이연속부분수열;

/**
 * https://cote.inflearn.com/contest/10/problem/03-06
 * 6. 최대 길이 연속부분수열
 * 설명
 *
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 *
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 *
 * 이며 그 길이는 8입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
 *
 * 두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 최대 길이를 출력하세요.
 *
 *
 * 예시 입력 1
 *
 * 14 2
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 예시 출력 1
 *
 * 8
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();

        int n = kb.nextInt();
        int k = kb.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(main.solution(n, k, arr));
    }

    public int solution (int n, int k, int[] arr) {
        int answer=0;
        int lt = 0, rt = 0, cnt = 0;

        // 1이 연속된 수열의 길이를 구하는 공식 = rt-lt+1
        // 배열의 0인 부분을 1로 바꾼다는 생각으로 배열의 끝까지 반복. => lt가 커질수록 rt와의 거리가 가까우므로 연속된 1의 갯수가 적다는 것을 의미한다.
        // cnt는 0을 1로 바꾼 갯수를 의마한다. 0을 1로 바꿀 수 있는 최대 횟수 k가 넘지 않도록 확인해야한다.
        for (rt = 0; rt < n; rt++) {
            // 0인 부분을 1로 바꾼 갯수를 증감.
            if (arr[rt] == 0) cnt++;
            while (cnt > k) {
                // 1을 0으로 바꾼 부분을 차감.
                if (arr[rt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

}
