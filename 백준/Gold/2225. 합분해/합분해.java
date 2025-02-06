import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static int[][] dp;
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");    
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        dp = new int[K+1][N+1];

        for(int i=0; i<=N; i++){
            dp[1][i]=1;
        }
        for(int i=1; i<=K; i++){
            dp[i][0]=1;
        }
        for(int k=2; k<=K; k++){
            for(int n=1; n<=N; n++){
                dp[k][n] = (dp[k][n - 1] + dp[k - 1][n]) % MOD;
            }
        }
        System.out.println(dp[K][N]);
    }
}