import java.util.*;
import java.io.*;

public class Main {
    static int M, N, K;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 탐색을 위한 x 변화량
    static int[] dy = {1, -1, 0, 0}; // 상하좌우 탐색을 위한 y 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 세로 크기
        N = Integer.parseInt(st.nextToken()); // 가로 크기
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        visited = new boolean[M][N]; // 방문 여부 체크
        map = new int[M][N]; // 지도 배열 (사각형 영역 표시)

        // 직사각형 입력 및 방문 처리
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 주어진 직사각형을 방문 처리
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    visited[i][j] = true;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();

        // BFS 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) { // 방문하지 않은 곳이면 새로운 영역
                    areas.add(bfs(i, j));
                }
            }
        }

        // 정렬 후 결과 출력
        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    // BFS 구현
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int areaSize = 1; // 현재 영역의 크기

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curX = now[0];
            int curY = now[1];

            // 상하좌우 탐색
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                // 범위를 벗어나지 않고 방문하지 않은 곳이면 탐색
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    areaSize++;
                }
            }
        }

        return areaSize;
    }
}
