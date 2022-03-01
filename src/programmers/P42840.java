package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
 *
 * 문제 설명
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class P42840 {

    public static void main(String[] args) {
        P42840 p = new P42840();

        int [] answer = p.solution(new int[]{1, 2, 3, 4, 5});
        System.out.print(Arrays.toString(answer));
    }

    public int [] solution(int [] answers) {
        int [] answer = {};

        List<Integer> answerList = new ArrayList<>();

        int [] pattern1 = new int [] {1, 2, 3, 4 ,5};
        int [] pattern2 = new int [] {2, 1 ,2, 3, 2, 4, 2, 5};
        int [] pattern3 = new int [] {3, 3, 1, 1, 2, 2, 4 ,4, 5, 5};

        int answer1Count = 0;
        int answer2Count = 0;
        int answer3Count = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern1[i % pattern1.length]) {
                answer1Count++;
            }
            if (answers[i] == pattern2[i % pattern2.length]) {
                answer2Count++;
            }
            if (answers[i] == pattern3[i % pattern3.length]) {
                answer3Count++;
            }
        }

        int maxAnswerCount = Math.max(answer1Count, Math.max(answer2Count, answer3Count));
//        int maxAnswerCount = answer1Count;
//        if (answer2Count > maxAnswerCount) maxAnswerCount = answer2Count;
//        if (answer3Count > maxAnswerCount) maxAnswerCount = answer3Count;

        if (maxAnswerCount == answer1Count) answerList.add(1);
        if (maxAnswerCount == answer2Count) answerList.add(2);
        if (maxAnswerCount == answer3Count) answerList.add(3);

//        answer = answerList.stream().mapToInt(i -> i).toArray();
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
