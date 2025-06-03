import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken()); 
        R = Integer.parseInt(st.nextToken()); 
        
        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = new ArrayList<>();
                        int totalPopulation = bfs(i, j, union);

                        if (union.size() > 1) {
                            moved = true;
                            int newPopulation = totalPopulation / union.size();
                            for (int[] country : union) {
                                population[country[0]][country[1]] = newPopulation;
                            }
                        }
                    }
                }
            }
            if (!moved) break;
            
            days++;
        }
        
        System.out.println(days);
    }

    static int bfs(int startX, int startY, List<int[]> union) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        union.add(new int[]{startX, startY});
        int totalPopulation = population[startX][startY];
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(population[x][y] - population[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    totalPopulation += population[nx][ny];
                }
            }
        }
        
        return totalPopulation;
    }
}