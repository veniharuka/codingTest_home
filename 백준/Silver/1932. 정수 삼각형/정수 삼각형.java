import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 삼각형 배열 생성 (2차원 배열로 변경)
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        
        // 삼각형 입력 받기
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 첫 번째 값 저장
        dp[0][0] = triangle[0][0];
        
        // DP로 최대값 계산
        for(int i = 1; i < n; i++) {
            // 각 층의 맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            // 중간 값들
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            
            // 각 층의 맨 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        // 마지막 층에서 최대값 찾기
        int max = dp[n-1][0];
        for(int i = 1; i < n; i++) {
            max = Math.max(max, dp[n-1][i]);
        }
        
        System.out.println(max);
    }
}