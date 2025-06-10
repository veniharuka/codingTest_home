import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] children = new int[N];
        
        for (int i = 0; i < N; i++) {
            children[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (children[j] < children[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int maxLIS = 0;
        for (int i = 0; i < N; i++) {
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        System.out.println(N - maxLIS);
    }
}