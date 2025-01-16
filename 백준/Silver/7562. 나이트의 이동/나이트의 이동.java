import java.util.*;
import java.io.*;

public class Main {
    static int testCase;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int length;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        // 주어진 testCase 수 만큼 반복
        for (int t = 0; t < testCase; t++) {
            length = Integer.parseInt(br.readLine());
            visited = new boolean[length][length];
                
            // BFS 실행 전에 방문 배열 초기화
            String[] start = br.readLine().split(" ");
            int startX = Integer.parseInt(start[0]);
            int startY = Integer.parseInt(start[1]);

            String[] end = br.readLine().split(" ");
            int endX = Integer.parseInt(end[0]);
            int endY = Integer.parseInt(end[1]);

            System.out.println(bfs(startX, startY, endX, endY, visited));
        }
    }

    static int bfs(int startX, int startY, int endX, int endY, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{startX, startY, 0}); // x, y, 이동 횟수
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int moves = cur[2];

            // 목적지에 도착했다면 이동 횟수 반환
            if (x == endX && y == endY) {
                return moves;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < length && ny < length) {
                    if (!visited[nx][ny]) {
                        q.offer(new int[]{nx, ny, moves + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}
