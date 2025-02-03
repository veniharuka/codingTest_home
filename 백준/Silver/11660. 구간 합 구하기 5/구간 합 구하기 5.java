import java.io.*;

public class Main {
    static int N, M;
    static int[][] graph, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력 
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N + 1][N + 1]; 
        sum = new int[N + 1][N + 1];   

        // 그래프 입력
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(line[j - 1]);
                // 누적 합 계산
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + graph[i][j];
            }
        }

        // M개의 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] coordinate = br.readLine().split(" ");
            int x1 = Integer.parseInt(coordinate[0]);
            int y1 = Integer.parseInt(coordinate[1]);
            int x2 = Integer.parseInt(coordinate[2]);
            int y2 = Integer.parseInt(coordinate[3]);

            // 구간 합 계산 
            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
