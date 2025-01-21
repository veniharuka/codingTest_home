import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int [15][15];// 최대 14층 14호까지 고려
        
        for (int i = 1; i <= 14; i++) {
            dp[0][i] = i; // 0층 초기화
            dp[i][1] = 1; // 각 층의 1호는 1명
        }
        
        for (int k = 1; k <= 14; k++) {
            for (int n = 2; n <= 14; n++) {
                dp[k][n] = dp[k][n-1] + dp[k-1][n];
            }        
        }
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}