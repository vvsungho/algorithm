package inflearn.part01.특정단어뒤집기;

/**
 * https://cote.inflearn.com/contest/10/problem/01-05
 * 5. 특정 문자 뒤집기
 * 설명
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * a#b!GE*T@S
 * 예시 출력 1
 *
 * S#T!EG*b@a
 */

import java.util.Scanner;

public class Main {

    public String solution(String str) {
        char [] chars = str.toCharArray();
        // str 첫 번째 인덱스
        int lt = 0;
        // str 마지막 인덱스
        int rt = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            if (!Character.isAlphabetic(chars[lt])) {
                // str의 lt 인덱스가 알파벳이 아닐경우, 단어 뒤집지 않고 인덱스만 한 개 증가.
                lt ++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                // str의 rt 인덱스가 알파벳이 아닐경우, 단어 뒤집지 않고 인덱스만 한 개 감소.
                rt --;
            } else {
                // str[lt], str[rt]가 모두 알파벳 일 경우 str[lt], str[rt]값을 바꿔주어 뒤집는다.
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;

                // lt, rt 각각 인덱스 증가, 감소 처리.
                lt ++;
                rt --;
            }
        }
        String answer = String.valueOf(chars);
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.solution(kb.next()));
    }

}
