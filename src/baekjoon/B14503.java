package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14503 {

    public static final int[] dx = { -1, 0, 1, 0 };
    public static final int[] dy = { 0, 1, 0, -1 };

    public static int n, m, r, c, d;
    public static int [][] inputArr;

    public static boolean [][] visited;
    public static int answer = 0;

    public static Robot robot;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        r = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        inputArr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                inputArr[i][j] = scanner.nextInt();
            }
        }

        robot = new Robot(r, c, d);
        visited[r][c] = true;
        ++answer;

        System.out.println(answer);

    }

    public static void bfs() {
        Queue<Robot> q = new LinkedList<Robot>();
        q.add(robot);

        while (!q.isEmpty()) {
            Robot r = q.poll();

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
                        q.add(new Robot(nx, ny, next_direction));
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
                        q.add(new Robot(nx, ny, d));
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

class Robot {
    int x;
    int y;
    int d;

    public Robot(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
