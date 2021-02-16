package baekjoon.test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class bfsTest {

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2); /* 주어진 노드를 시작 노드로 BFS 탐색 */
    }

}

class Graph {

    private int nodeCount;
//    private LinkedList<Integer> [] listArr; // 아래와 같다.
    private LinkedList<Integer> listArr [];

    public Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        this.listArr = new LinkedList[this.nodeCount]; // linked list arr
        for(int i = 0; i < this.nodeCount; i++) {
            this.listArr[i] = new LinkedList<Integer>();
        }
    }

    void addEdge(int v, int w) {
        this.listArr[v].add(w);
    }

    void bfs(int startNumber) {
        boolean [] visited = new boolean[this.nodeCount];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNumber] = true;
        queue.add(startNumber);

        while (!queue.isEmpty()) {
            startNumber = queue.poll();

            Iterator<Integer> i = this.listArr[startNumber].iterator();
            while (i.hasNext()) {
                int n = i.next();

                if (!visited[n]) {
                    visited[n] = !visited[n];
                    queue.add(n);
                }
            }
        }
    }
}
