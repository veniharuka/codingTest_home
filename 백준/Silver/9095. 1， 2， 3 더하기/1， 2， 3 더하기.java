import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        
        // DP 배열 초기값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4; i<11; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        // 테스트 케이스 처리
        for(int t=0; t<testCases; t++){
            int testCase = Integer.parseInt(br.readLine());
            System.out.println(dp[testCase]);
            
        }

    }
}