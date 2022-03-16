package inflearn.part01.문자열압축;

/**
 * https://cote.inflearn.com/contest/10/problem/01-11
 * 11. 문자열 압축
 * 설명
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 *
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 압축된 문자열을 출력한다.
 *
 *
 * 예시 입력 1
 *
 * KKHSSSSSSSE
 * 예시 출력 1
 *
 * K2HS7E
 * 예시 입력 2
 *
 * KSTTTSEEKFKKKDJJGG
 * 예시 출력 2
 *
 * KST3SE2KFK3DJ2G2
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();

        System.out.println(m.solution(kb.nextLine()));
    }

    public String solution(String s) {

        // 입력받은 s을 for문 돌면서 기준글자와 그 다음글자를 비교하여 같을 경우 cnt를 증감하여 처리한다.

        StringBuilder answer = new StringBuilder();

        // 다음글자와 비교해야하므로 맨마지막 글자 체크 시 indexOutOf Exception을 방지하기위해 입력받은 문자에 공백을 하나 더한다.
        s += " ";

        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) cnt ++; // 기준글자와 다음글자가 동일할경우 cnt 증감.
            else {
                // 기준글자가 다음글자와 다를경우 출력할 문자에 더해주고 2 이상의 숫자만 출력되야하므로 1이 넘는지 체크한다. 그 후 cnt를 초기화 한다.
                answer.append(s.charAt(i));
                if (cnt > 1) {
                    answer.append(cnt);
                }
                cnt = 1;
            }
        }

        return answer.toString();
    }

}
