package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 * 예산
 */
public class P12982 {

    public static void main(String[] args) {
        P12982 p = new P12982();
        p.solution(new int[]{1,3,2,5,4}, 9);
    }

    public int solution(int[] d, int budget) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < d.length; i++) {
            list.add(d[i]);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            budget -= list.get(i);
            if (budget>=0) {
                answer ++;
            } else {
                break;
            }
        }

        return answer;
    }

}
