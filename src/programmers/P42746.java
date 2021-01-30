package programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 * 가장 큰 수
 */
public class P42746 {
    public static void main(String[] args) {
        System.out.println(solution(new int [] {6, 10, 2}));
        System.out.println(solution(new int [] {3, 30, 34, 5, 9}));
        System.out.println(solution(new int [] {0, 0, 0, 0}));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] numbersToString = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numbersToString[i] = String.valueOf(numbers[i]);
        }


        Arrays.sort(numbersToString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2)); // 자릿수까지 비교하고 스트링 내림차순
//        Arrays.sort(numbersToString, Collections.reverseOrder()); // 단순 내림차순 방법

        if(numbersToString[0].equals("0")) {
            return "0";
        }

        for (int i = 0; i < numbersToString.length; i++) {
            answer += numbersToString[i];
        }

        return answer;
    }
}
