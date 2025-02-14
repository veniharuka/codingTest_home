import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[N + 1];

        // Base case
        dp[1] = true; 
        if (N >= 2) dp[2] = false;  
        if (N >= 3) dp[3] = true; 

        // DP 계산
        for (int i = 4; i <= N; i++) {
            if (!dp[i - 1] || !dp[i - 3]) {
                dp[i] = true;  
                } else {
                dp[i] = false; 
            }
        }


        if (dp[N]) {
            System.out.println("SK");  
            } else {
                System.out.println("CY"); 
            }

        }
}
