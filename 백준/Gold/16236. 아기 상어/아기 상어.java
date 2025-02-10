import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int sharkX, sharkY, sharkSize = 2, eatCount = 0, time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) { // 아기 상어 위치 저장
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0; // 상어 위치는 빈 칸으로 처리
                }
            }
        }

        // BFS 실행
        while (true) {
            int result = bfs();
            if (result == -1) break; // 먹을 수 있는 물고기가 없으면 종료
            time += result;
        }

        System.out.println(time);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];
        q.add(new int[]{sharkX, sharkY, 0}); // (x, y, 이동 거리)
        visited[sharkX][sharkY] = true;

        List<int[]> fishList = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int curX = now[0];
            int curY = now[1];
            int curDist = now[2];

            if (curDist > minDist) break; // 더 먼 거리면 탐색 중단

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (map[nx][ny] <= sharkSize) { // 지나갈 수 있는 경우
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, curDist + 1});

                        if (map[nx][ny] > 0 && map[nx][ny] < sharkSize) { // 먹을 수 있는 물고기
                            fishList.add(new int[]{nx, ny, curDist + 1});
                            minDist = curDist; // 가장 가까운 거리 갱신
                        }
                    }
                }
            }
        }

        if (fishList.isEmpty()) return -1; // 먹을 수 있는 물고기가 없음

        // 가장 위 -> 가장 왼쪽 물고기 선택 (정렬)
        fishList.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int[] target = fishList.get(0);

        // 상어 위치 이동 및 맵 갱신
        sharkX = target[0];
        sharkY = target[1];
        map[sharkX][sharkY] = 0;
        eatCount++;

        // 상어 크기 증가
        if (eatCount == sharkSize) {
            sharkSize++;
            eatCount = 0;
        }

        return target[2]; // 이동 거리 반환
    }
}
