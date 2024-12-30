import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int dp[] = new int[n];
        int input[] = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        // 초기값 설정
        dp[0] = input[0];
        int max = input[0];
        
        for (int i = 1; i < n; i++) {
            // 이전 dp값 + 현재값과 현재값 중 큰 값을 선택
            dp[i] = Math.max(dp[i-1] + input[i], input[i]);
            max = Math.max(max, dp[i]);
        }
        
        System.out.println(max);
    }
}