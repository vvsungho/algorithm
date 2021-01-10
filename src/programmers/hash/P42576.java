package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 2021-01-10
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 프로그래머스
 * 난이도: level1
 * 유형: hash
 */

public class P42576 {

    public static void main(String[] args) {

        //                String[] participant = {"leo", "kiki", "eden"};
        //                String[] completion = {"kiki", "eden"};

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        //        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        //        String[] completion = {"stanko", "ana", "mislav"};


        P42576 p = new P42576();
        System.out.println(p.solution(participant, completion));

    }

    /**
     * 풀이과정
     * 전제: 미완주자는 항상 1명.
     * 1. 참가자를 참가자명, 해당 이름을 가진 참가자 수 HashMap을 만든다. (동명이인 시 미완주자 추출을 위해)
     * 2. 완주자 배열로 for문을 돌며 참가자 HashMap에 있는 해당이름을 가진 참가자수를 1명씩 뺀다. 참가자명이 1명일 때는 해당이름 다 체크한 것으로 간주하고 HashMap에서 삭제한다.
     * 3. 위 과정에서 미완주자는 완주자명단에 없기 때문에 HashMap에 그대로 남아있고, 동명이인의 수가 1보다 크면 동명이인 중 미완주자가 있음을 뜻한ㄷ. HashMap에 남은 것이 미완주자가 된다.
     */
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        // HashMap 생성
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                map.replace(participant[i], map.get(participant[i]) + 1);
            } else {
                map.put(participant[i], 1);
            }
        }

        // 완주자 for문
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                // 동명이인의 수
                int count = map.get(completion[i]);
                // 동명이인의 수가 1명이면 해당이름을 모두 체크했으므로 HashMap에서 삭제.
                if (count == 1) { map.remove(completion[i]); }
                // 동명이인의 수가 2명이상이면 완주자 for문을 돌며 한 명씩 빼준다.
                else if (count > 1) { map.replace(completion[i], count - 1); }
                else { answer = completion[i]; }
            }
        }

        Iterator<String> iterator = map.keySet().iterator();
        // HashMap에 남은 이름이 미완주자.
        while (iterator.hasNext()) {
            answer = iterator.next();
        }

        return answer;
    }

}
