package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 * 큰 수 만들기
 * 20201023
 */

/**
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거 했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자 입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수 입니다.
 */

/**
 * 큰수를 만들 되 각각 숫자의 위치가 바뀌어선 안됨. "4177252841" => 해당 문자에서 8이 제일 앞으로 나올 수 없음. 요소를 제거는 가능하지만 위치를 바꾸어선 안된다.
 */

/**
 * 탐욕법. 하나하나 비교하면 정확하지만 시간이 오래걸린다. 시간을 줄이면서 최선의 방법으로 값을 구하는 방식.
 * 제거할 숫자만 큼 앞에서 수를 잘라서 비교한다.
 * 이해안감.
 */


import java.util.ArrayList;
import java.util.List;


public class P42883 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2)); // "94"
        System.out.println(solution("1231234", 3)); // "3234"
        System.out.println(solution("4177252841", 4)); // "775841" // 752841 // 775841// 725841
        //        System.out.println(solution("0000", 3)); // "0"
    }

    public static String solution(String number, int k) {
        StringBuilder s = new StringBuilder();

        int digit = number.length() - k;

        int index = 0;

        // 구하는 자릿 수 까지 반복 비교.
        for (int i = 0; i < digit; i++) {
            char max = '0';
            // 자기 자신 바로 다음 대상 부터 (index + 1)
            for (int j = index + 1; j <= k + i; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    index = j;
                }
            }
            s.append(max);
        }

        return s.toString();
    }

}
