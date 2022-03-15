package inflearn.part01.가장짧은문자거리;

/**
 * https://cote.inflearn.com/contest/10/problem/01-10
 * 10. 가장 짧은 문자거리
 * 설명
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 *
 * 예시 입력 1
 *
 * teachermode e
 * 예시 출력 1
 *
 * 1 0 1 2 1 0 1 2 2 1 0
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();
//        System.out.println(Arrays.toString(m.solution(kb.next(), kb.next())));
        int [] answer = m.solution(kb.next(), kb.next());

        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    public int[] solution(String str, String target) {
        int [] answer = new int[str.length()];
        char t = target.charAt(0);

        int distance = str.length();
        // 문자열의 첫번 째는 거리비교가 안되므로 최대치로 설정해놓음.

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 왼쪽에서 오른쪽으로 가면서 거리비교
            // 문자열 길이만큼 for문을 수행하면서 타겟 char와 동일한 char일 경우 거리를 0으로 설정.
            // 동일하지 않을 경우 거리1씩 증가.
            distance++;

            if (c == t) {
                distance = 0;
            }
            answer[i] = distance;
        }

        // 오른쪽에서 왼쪽으로 가며 거리 비교. (역순으로 다시 검사)
        // 왼쪽으로 오른쪽으로 가며 거리 비교한 것과 거리를 비교하며 더 가까운 거리를 배열에 다시 넣어준다.
        distance = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            distance++;

            if (c == t) {
                distance = 0;
            }

            if (distance < answer[i]) {
                answer[i] = distance;
            }
        }

        return answer;
    }

}
