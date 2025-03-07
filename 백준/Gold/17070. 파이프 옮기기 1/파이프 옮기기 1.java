import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][2][0] = 1; 

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                if (board[i][j] == 1) continue; 

                if (j - 1 >= 1) {
                    dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                if (i - 1 >= 1) {
                    dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                if (i - 1 >= 1 && j - 1 >= 1 && board[i - 1][j] == 0 && board[i][j - 1] == 0) {
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        int result = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
        System.out.println(result);
    }
}
