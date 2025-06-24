import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        dfs(0, 0);
        System.out.println(minDiff);
    }

    static void dfs(int depth, int idx) {
        if (depth == N / 2) {
            calcDiff();
            return;
        }
        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calcDiff() {
        int start = 0, link = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i] && visited[j]) {
                    start += S[i][j];
                }
                else if (!visited[i] && !visited[j]) {
                    link += S[i][j];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(start - link));
    }
}
