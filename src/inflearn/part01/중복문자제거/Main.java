package inflearn.part01.중복문자제거;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-06
 * 6. 중복문자제거
 * 설명
 *
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 *
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *
 * 입력
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 */

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println(m.solution(scanner.next()));
    }

    public String solution(String s) {
        String answer = "";

        // indexOf(s)는 s에 해당하는 charAt(i)가 최초로 발견되는 index 번호를 리턴한다.
        // 최초로 리턴한 index와 for문의 index와 같다면 해당 char가 첫 번째로 발견된 것 이기 때문에 해당 char를 연산하고, 이후에 발견된 char는 index번호가 다르므로 중복이라고 인지한다.

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i) {
                answer += s.charAt(i);
            }
        }

        return answer;
    }

}
