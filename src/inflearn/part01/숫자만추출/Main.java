package inflearn.part01.숫자만추출;

/**
 * https://cote.inflearn.com/contest/10/problem/01-09
 * 9. 숫자만 추출
 * 설명
 *
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 *
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 *
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 *
 * 입력
 * 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *
 *
 * 출력
 * 첫 줄에 자연수를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * g0en2T0s8eSoft
 * 예시 출력 1
 *
 * 208
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();
        System.out.println(m.solution(kb.nextLine()));
    }

      public int solution(String s) {
        int answer = 0;

        // 0~9의 아스키코드는 십진수 48~57이다.
        // for문을 수행할 때마다 자릿수를 한자리씩 올려준다. => 10
        // character 0의 아스키코드는 48이므로 숫자c의 48을 뺀 수를 더해준다.

        for (char c : s.toCharArray()) {
            if (c > 47 && c < 58) {
                System.out.println(c - 48);
                answer = (answer * 10) + c - 48;
            }
        }

        return answer;
      }

}
