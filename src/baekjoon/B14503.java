package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B14503 {

    public static int n, m, r, c, d;
    public static int [][] arr;

    public static boolean [][] visited;
    public static int answer = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = 3;
        m = 3;
        r = 1; // 좌표 x
        c = 1; // 좌표 y
        d = 0; // 현재 방향 (북동남서)

    }

}

class Item {
    int x;
    int y;
    int d;

    public Item(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
