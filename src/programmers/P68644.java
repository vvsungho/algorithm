package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 * 두 개 뽑아서 더하기
 */

public class P68644 {

    public static void main(String[] args) {
        P68644 p = new P68644();
        p.solution(new int[]{2,1,3,4,1});
    }

    public int[] solution(int[] numbers) {
        int[] answer = {};

        List <Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }

            }
        }

        Collections.sort(list);

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
