package inflearn.part02.가위바위보;

/**
 * https://cote.inflearn.com/contest/10/problem/02-03
 * 3. 가위 바위 보
 * 설명
 *
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 *
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 *
 * 예를 들어 N=5이면
 *
 * Image1.jpg
 *
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
 *
 * 두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 * 세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
 *
 *
 * 출력
 * 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 * 예시 출력 1
 *
 * A
 * B
 * A
 * B
 * D
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();

        int n = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = kb.nextInt();
        }

        for (String s : m.solution(n, arr1, arr2)) System.out.println(s);
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = winLose(arr1[i], arr2[i]);
        }
        return answer;
    }

    public String winLose(int n, int m) {
        if (n == 1) {
            if (m == 1) {
                return "D";
            } else if (m == 2) {
                return "B";
            } else if (m == 3){
                return "A";
            } else {
                return null;
            }
        } else if (n == 2) {
            if (m == 1) {
                return "A";
            } else if (m == 2) {
                return "D";
            } else if (m == 3){
                return "B";
            } else {
                return null;
            }
        }  else if (n == 3) {
            if (m == 1) {
                return "B";
            } else if (m == 2) {
                return "A";
            } else if (m == 3){
                return "D";
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

}
