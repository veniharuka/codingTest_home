import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        int[] dp = new int[1001];
        dp[1] = 1; 

        for (int i = 2; i <= 1000; i++) {
            dp[i] = 1;

            for (int j = 1; j <= i/2; j++) {
                dp[i] += dp[j];
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[n]).append("\n");
        }
        
        System.out.print(sb);
    }
}