import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            graph[x].add(y);
            graph[y].add(x);
        }

        int minKevinBacon = Integer.MAX_VALUE;
        int answer = 0;
        
        for (int i = 1; i <= N; i++) {
            int baconNumber = bfs(i);
            if (baconNumber < minKevinBacon) {
                minKevinBacon = baconNumber;
                answer = i;
            }
        }
        
        System.out.println(answer);
    }
    
    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        
        queue.add(new int[]{start, 0});
        visited[start] = true;
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int depth = cur[1];
            
            sum += depth;
            
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }
        
        return sum;
    }
}