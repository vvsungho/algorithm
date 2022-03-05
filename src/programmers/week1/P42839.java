package programmers.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * 소수 찾기
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */

public class P42839 {

    public static void main(String[] args) {
//        int [] numbers = new int [] {0, 1, 3};
        int [] numbers = new int [] {1,7};
//        int [] numbers = new int [] {0, 1, 1};
        P42839 p42839 = new P42839();
        System.out.println("Answer: " + Arrays.toString(p42839.solution(numbers)));
    }

    public int[] solution(int [] numbers) {
        List<Integer> tmpAnswerList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!numberList.contains(numbers[i])) {
                numberList.add(numbers[i]);
            }
            for (int j = i + 1; j < numbers.length; j++) {
                int number = Integer.parseInt(numbers[i] + "" + numbers[j]);
                if (!numberList.contains(number)) {
                    numberList.add(number);
                }
            }
        }

        System.out.println("숫자 조합: " + numberList);

        for (int i = 0; i < numberList.size(); i++) {

            for (int j = 2; j <= numberList.get(i); j++) {
                if (numberList.get(i) % j == 0) {
                    break;
                }
            }
            tmpAnswerList.add(numberList.get(i));
        }

        int [] answers = new int [tmpAnswerList.size()];
        for (int i = 0; i < tmpAnswerList.size(); i++) {
            answers[i] = tmpAnswerList.get(i);
        }

        return answers;
    }
}
