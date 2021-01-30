package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * 기능개발
 */
public class P42856 {

    public static void main(String[] args) {
        P42856 p = new P42856();
        p.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        List<Integer> distinctList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int balance = 100 - progresses[i];
            int speed = speeds[i];
            int value = (int)Math.ceil((double)balance / (double)speed);
            list.add(value);
        }

        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) {
                    list.set(j, list.get(i));
                }
                break;
            }
            if (!distinctList.contains(list.get(i))) {
                distinctList.add(list.get(i));
            }
        }

        distinctList.forEach(distinctItem -> {
            newList.add(0);
            list.forEach(item -> {
                if (distinctItem == item) {
                    newList.set(newList.size() - 1, newList.get(newList.size() - 1) + 1);
                }
            });
        });

        answer = new int[newList.size()];

        for (int i = 0; i < newList.size(); i++) {
            answer[i] = newList.get(i);
        }
        return answer;
    }
}
