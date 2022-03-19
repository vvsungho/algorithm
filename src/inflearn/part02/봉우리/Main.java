package inflearn.part02.봉우리;

/**
 * 10. 봉우리
 * 설명
 *
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 *
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 *
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * 만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
 *
 * Image1.jpg
 *
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 *
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 *
 * 출력
 * 봉우리의 개수를 출력하세요.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 5 3 7 2 3
 * 3 7 1 6 1
 * 7 2 5 3 4
 * 4 3 6 4 1
 * 8 7 3 5 2
 * 예시 출력 1
 *
 * 10
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Main m = new Main();
        int n = kb.nextInt();
        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(m.solution(n, arr));

    }


    // 2차원배열 안의 목표타겟에서 서북동남 방향으로 비교하기 위한 좌표배열.
    int [] x = {-1 , 0 , 1 , 0};
    int [] y = {0 , 1 , 0 , -1};

    public int solution (int n, int[][] arr) {
        int answer = 0;

        // 자신의 상하좌우 보다 클 경우 증감.
        for (int i =0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < x.length; k++) {
                    int nx = i + x[k];
                    int ny = j + y[k];
                    // i와 j를 2라고 가정하고
                    // k는 0일때,
                    // i
                    // out of index exception 방지
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }

        return answer;
    }

}
