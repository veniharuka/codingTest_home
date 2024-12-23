import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        
        dp[1] = 0; // 1은 이미 1이므로 연산 필요 없음

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // 기본적으로 1을 뺀 경우
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 2로 나누는 경우
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1); // 3으로 나누는 경우
        }

        System.out.println(dp[n]);
    }
}
