package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test {

    public static final int[] dx = { -1, 0, 1, 0 };
    public static final int[] dy = { 0, 1, 0, -1 };

    public static int n, m, r, c, d;
    public static int [][] inputArr;

    public static boolean [][] visited;
    public static int answer = 0;

    public static Test2 robot;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt(); // 좌표 x
        c = scanner.nextInt(); // 좌표 y
        d = scanner.nextInt(); // 현재 방향 (북동남서)

        inputArr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inputArr[i][j] = scanner.nextInt();
            }
        }

        robot = new Test2(r, c, d); // 현재 좌표와 방향 설정
        visited[r][c] = true; // 시작시점 좌표 true
        ++answer;

        System.out.println(answer);

    }

    public static void bfs() {
        Queue<Test2> q = new LinkedList<Test2>();
        q.add(robot);

        while (!q.isEmpty()) {
            Test2 r = q.poll();

            int x = r.x;
            int y = r.y;
            int d = r.d;

            int next_direction = d;
            boolean flag = false;

            // 2번 과정 : 4방향 검사
            for (int i = 0; i < 4; i++) {
                // 1번 과정
                next_direction = turnLeft(next_direction);
                int nx = x + dx[next_direction];
                int ny = y + dy[next_direction];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (inputArr[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Test2(nx, ny, next_direction));
                        ++answer;
                        flag = true;
                        break;
                    }
                }
            }

            // 3번 과정
            if (!flag) {
                next_direction = turnBack(d);
                int nx = x + dx[next_direction];
                int ny = y + dy[next_direction];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (inputArr[nx][ny] == 0) {
                        q.add(new Test2(nx, ny, d));
                    }
                }

            }
        }

    }

    public static int turnLeft(int d) {
        if(d == 0) {
            return 3;
        } else if(d == 1) {
            return 0;
        } else if(d == 2) {
            return 1;
        } else {
            return 2;
        }
    }
    public static int turnBack(int d) {
        if(d == 0) {
            return 2;
        } else if(d == 1) {
            return 3;
        } else if(d == 2) {
            return 0;
        } else {
            return 1;
        }
    }

}

class Test2 {
    int x;
    int y;
    int d;

    public Test2(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
