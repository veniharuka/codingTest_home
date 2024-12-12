import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int pictureCount = 0; // 그림의 개수
        int maxWidth = 0; // 가장 넓은 그림의 넓이
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    pictureCount++;
                    maxWidth = Math.max(maxWidth, bfs(i, j)); // BFS로 넓이 계산
                }
            }
        }
        
        System.out.println(pictureCount);
        System.out.println(maxWidth);
    }
    
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        int width = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            width++;
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return width; // 해당 그림의 넓이 반환
    }
}
