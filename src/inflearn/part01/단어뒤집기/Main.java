package inflearn.part01.단어뒤집기;

/**
 * https://cote.inflearn.com/contest/10/problem/01-04
 * 4. 단어 뒤집기
 * 설명
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
 *
 *
 * 출력
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // StringBuilder를 활용한 방법.
    public List<String> solution(String[] arr) {

        List<String> answerList = new ArrayList<>();

        for (String str : arr) {
            // String 뒤집는 메서드
            answerList.add(new StringBuilder(str).reverse().toString());
        }

        return answerList;
    }

    // 직접 뒤집는 방법
    public List<String> solution2(String[] arr) {
        List<String> answerList = new ArrayList<>();

        for (String str : arr) {
            char charArr [] = str.toCharArray();
            // char array의 첫 번째 인덱스, // char array의 마지막 인덱스
            int lt = 0, rt = charArr.length - 1;

            // lt가 rt보다 커질경우 반복문 종료.
            while (lt < rt) {
                // lt, rt에 해당하는 인덱스의 char끼리 바꿔준 후 lt는 증감, rt는 감소 처리.
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt--;
                rt++;
            }
            // charArr의 요소 하나씩 붙여 String으로 만들어줌.
            String answerItem = String.valueOf(charArr);
            answerList.add(answerItem);
        }

        return answerList;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        String [] arr = new String[n];

        for (int i = 0; i < n; i ++) {
            // TODO: next 와 nextLine 차이 체크
            arr[i] = kb.next();
        }

        for (String str : main.solution(arr)) {
            System.out.println(str);
        }
    }

}
