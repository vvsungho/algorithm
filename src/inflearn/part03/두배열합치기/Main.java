package inflearn.part03.두배열합치기;

/**
 * https://cote.inflearn.com/contest/10/problem/03-01
 * 1. 두 배열 합치기
 * 설명
 *
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 *
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 *
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 * 예시 출력 1
 *
 * 1 2 3 3 5 6 7 9
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();

        int n1 = kb.nextInt();
        int [] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = kb.nextInt();
        }

        int n2 = kb.nextInt();
        int [] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = kb.nextInt();
        }

        List<Integer> answer = m.solution(n1, n2, arr1, arr2);

        answer.forEach(item -> {
            System.out.print(item + " ");
        });
    }

    public List<Integer> solution(int n1, int n2, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();

        int arr1Index = 0;
        int arr2Index = 0;

        // 배열의 인덱스1, 인덱스2를 선언하고 answer list에 넣어준 배열의 값만 해당배열인덱스를 증감한다.
        while (arr1Index < n1 && arr2Index < n2) {
            answer.add(arr1[arr1Index] < arr2[arr2Index] ? arr1[arr1Index++] : arr2[arr2Index++]);
        }

        // 배열의 나머지 데이터를 모두 넣어준다. 데이터를 모두 넣어준 배열이라면 해당for문을 실행하지 않음.
        for (int i = arr1Index; i < n1; i++) {
            answer.add(arr1[i]);
        }

        // 배열의 나머지 데이터를 모두 넣어준다. 데이터를 모두 넣어준 배열이라면 해당for문을 실행하지 않음.
        for (int i = arr2Index; i < n2; i++) {
            answer.add(arr2[i]);
        }

        return answer;
    }
}
