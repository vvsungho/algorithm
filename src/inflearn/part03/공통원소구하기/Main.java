package inflearn.part03.공통원소구하기;

/**
 * https://cote.inflearn.com/contest/10/problem/03-02
 * 2. 공통원소 구하기
 * 설명
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 *
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 *
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 * 예시 출력 1
 *
 * 2 3 5
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main main = new Main();
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

        List<Integer> answer = main.solution(n1, n2, arr1, arr2);

        answer.forEach(item -> {
            System.out.print(item + " ");
        });
    }

    // 오름차순 정렬 후 값이 똑같은 경우 두 배열 인덱스를 같이 증감하고, 값이 작다는 것은 두 배열에서 비교 기준값보다 작은 값이 없다는 것을 의미한다.
    // 값이 더 작은쪽 배열 인덱스를 증감하여. 반복을 비교한다.
    // 두 배열을 오름차순으로 정렬하는 것이 포인트.

    public List<Integer> solution(int n1, int n2, int[] arr1, int[] arr2) {
        List<Integer> answer = new ArrayList<>();

        // 오름차순 정렬
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int index1 = 0;
        int index2 = 0;

        while (index1 < n1 && index2 < n2) {
            if (arr1[index1] == arr2[index2]) {
                answer.add(arr1[index1]);
                index1 ++;
                index2 ++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        return answer;
    }

}
