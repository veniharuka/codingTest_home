import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");  // split(" ") 수정
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int connectedComponents = 0;
        
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        // 간선 정보 입력
        for(int i = 0; i < M; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 방문 배열 초기화
        visited = new boolean[N + 1];
        
        // 연결 요소 개수 계산
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                bfs(i);
                connectedComponents++;
            }
        }
        
        System.out.println(connectedComponents);
    }
    
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            for(int next : graph[current]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}