import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0}; // 상하좌우앞뒤
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1}; // 위 아래 층 확인
    static boolean[][][] visited;
    static int[][][] graph;
    static int M, N, H;
    static int minDay = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        graph = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 그래프 입력 받기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                String[] line = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    graph[h][n][m] = Integer.parseInt(line[m]);
                }
            }
        }

        // 이미 모두 익었는지 확인
        boolean already = true;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph[h][n][m] == 0) already = false;
                }
            }
        }
        if (already) {
            System.out.println(0);
            return;
        }

        // BFS 실행
        bfs();

        // 결과 확인
        if (!checkTomato()) minDay = -1;
        System.out.println(minDay);
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[H][N][M];

        // 익은 토마토 찾아서 큐에 넣기
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph[h][n][m] == 1) {
                        q.add(new int[]{h, n, m, 0}); // 좌표와 날짜
                        visited[h][n][m] = true;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int z = current[0];
            int y = current[1];
            int x = current[2];
            int day = current[3];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                // 범위 및 방문 체크
                if (nz >= 0 && ny >= 0 && nx >= 0 && nz < H && ny < N && nx < M) {
                    if (!visited[nz][ny][nx] && graph[nz][ny][nx] == 0) {
                        graph[nz][ny][nx] = 1; // 토마토 익히기
                        q.add(new int[]{nz, ny, nx, day + 1}); // 다음 날짜로 진행
                        visited[nz][ny][nx] = true;
                        minDay = Math.max(minDay, day + 1); // 최소 날짜 갱신
                    }
                }
            }
        }
    }

    // 토마토가 모두 익었는지 확인하는 함수
    static boolean checkTomato() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph[h][n][m] == 0) return false;
                }
            }
        }
        return true;
    }
}
