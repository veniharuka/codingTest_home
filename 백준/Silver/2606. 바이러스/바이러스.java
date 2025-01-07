import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int computerPair = Integer.parseInt(br.readLine());
        int virusComputer =0;
        
        // 그래프 초기화
        graph = new ArrayList[computer+1];
        for(int i = 1; i <= computer; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
         // 간선 정보 입력
        for(int i = 0; i < computerPair; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        visited = new boolean[computer+1];
        bfs(1);
        // virusComputer 계산
        for(int i = 2; i <= computer; i++) {
            if(visited[i]) {
                virusComputer++;
            }
        }
        
        System.out.println(virusComputer);
        
        
       
    }
    static void bfs(int start){
            Queue<Integer> q = new ArrayDeque<>();
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