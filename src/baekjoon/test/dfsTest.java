package baekjoon.test;

public class dfsTest {

}

class DfsGraph {

    private int nV; // 정점의 개수
    private int [][] dfsGraph;  // 그래프
    private boolean [] visitArr; // 정점 방문 여부 확인 배열

    public DfsGraph(int nV) {
        this.nV = nV;

        /**
         * 그래프 초기화
         * put(int x, int y) 에서 입력되는 정점의 값은 0이상의 정수이나
         * 배열의 index는 0부터 시작이므로
         * ArrayIndexOutOfBoundsException 방지를 위해
         * 정점을 담는 인접행렬의 행과 열 size는 1을 더하여 초기화해줌.
         */
        this.dfsGraph = new int[this.nV+1][this.nV+1];

        /**
         * 정점 방문 여부 확인 배열 초기화
         * 그래프와 마찬가지로 정점의 개수에 +1하여 초기화
         */
        this.visitArr = new boolean[this.nV+1];
    }

    public int[][] getDfsGraph() {
        return dfsGraph;
    }
}

