import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(B);
            indegree[B]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");
            
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}