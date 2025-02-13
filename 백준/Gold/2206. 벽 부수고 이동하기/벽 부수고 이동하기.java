import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1}; 
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1}); 
        visited[0][0][0] = true;  

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int wall = cur[2];  
            int dist = cur[3];  

            if (x == N - 1 && y == M - 1) {
                return dist; 
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][wall]) {  
                        visited[nx][ny][wall] = true;
                        q.add(new int[]{nx, ny, wall, dist + 1});
                    } 
                    else if (map[nx][ny] == 1 && wall == 0 && !visited[nx][ny][1]) {  
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, 1, dist + 1});
                    }
                }
            }
        }
        return -1; 
    }
}
