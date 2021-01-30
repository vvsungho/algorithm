package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        boolean[] isVisited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){                                            // 인접 리스트 내부 초기화
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), SPACE);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }
        br.close();

        for(int i = 1; i < N; i++){                                                // 인접 리스트 입력 값 정렬
            Collections.sort(graph[i]);
        }

        dfs(V, graph, isVisited);                                                // dfs 실행 메소드

        isVisited = new boolean[N + 1];
        sb.append(NEW_LINE);

        bfs(V, graph, isVisited);                                                // bfs 실행 메소드

        System.out.println(sb.toString());                                // 버퍼에 담긴 노드 방문 순서를 한번에 출력
    }

    private static void dfs(int current, ArrayList<Integer>[] graph, boolean[] isVisited){
        if(isVisited[current]) return;
        isVisited[current] = true;

        sb.append(current).append(SPACE);            // 현재 방문한 노드값을 버퍼에 담아둠

        for(int next : graph[current]){                // next 변수에 현재 방문한 노드에 해당하는 리스트에 담겨있는 값들을 하나씩 할당
            if(!isVisited[next]){
                dfs(next, graph, isVisited);        // 다음 방문할 노드 값으로 바꾸어 재귀 함수 실행
            }
        }
    }

    private static void bfs(int current, ArrayList<Integer>[] graph, boolean[] isVisited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);
        isVisited[current] = true;

        while(!queue.isEmpty()){
            current = queue.poll();
            sb.append(current).append(SPACE);

            for(int next : graph[current]){
                if(!isVisited[next]){
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
