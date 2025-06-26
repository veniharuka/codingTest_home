import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] board;
    static int[][] sumW, sumB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[][] diffW = new int[N][M]; 
        int[][] diffB = new int[N][M]; 

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
                diffW[i][j] = (board[i][j] == expectedW) ? 0 : 1;
                diffB[i][j] = (board[i][j] == expectedB) ? 0 : 1;
            }
        }

        sumW = new int[N + 1][M + 1];
        sumB = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sumW[i][j] = sumW[i - 1][j] + sumW[i][j - 1] - sumW[i - 1][j - 1] + diffW[i - 1][j - 1];
                sumB[i][j] = sumB[i - 1][j] + sumB[i][j - 1] - sumB[i - 1][j - 1] + diffB[i - 1][j - 1];
            }
        }

        int minPaint = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int cntW = getSum(sumW, i, j, K);
                int cntB = getSum(sumB, i, j, K);
                minPaint = Math.min(minPaint, Math.min(cntW, cntB));
            }
        }
        System.out.println(minPaint);
    }

    static int getSum(int[][] sum, int x, int y, int k) {
        return sum[x][y] - sum[x - k][y] - sum[x][y - k] + sum[x - k][y - k];
    }
}
