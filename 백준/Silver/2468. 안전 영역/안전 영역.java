import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] graph;
    static boolean[][] visited;
    static int N;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        
        // 최대 높이 찾기
        int maxHeight = 0;
        //그래프 입력받기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }
        
        // 각 높이별로 안전영역 계산
        int maxSafetyZone = 1; // 아무 지역도 물에 잠기지 않을 수 있음
        for(int height = 0; height < maxHeight; height++) {
            visited = new boolean[N][N];
            int count = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j] && graph[i][j] > height) {
                        count++;
                        bfs(i, j, height);
                    }
                }
            }
            maxSafetyZone = Math.max(maxSafetyZone, count);
        }
        
        System.out.println(maxSafetyZone);
    }
    
    static void bfs(int x, int y, int height){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N){
                    if(!visited[nx][ny] && graph[nx][ny] > height){
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}