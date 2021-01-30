package programmers;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * K번쨰 수
 */
public class P42748 {

    public static void main(String[] args) {
        P42748 p = new P42748();
        p.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];
        int index = 0;

        for (int i = 0; i < commands.length; i++) {
            int [] command = commands[i];

            List<Integer> list = new ArrayList<>();

            for (int j = command[0] - 1; j < command[1]; j++) {
                list.add(new Integer(array[j]));
            }

            Collections.sort(list);
            answer[index++] = list.get(command[2]-1);
        }

        return answer;
    }



}
