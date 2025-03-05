import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] wires;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        wires = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken()); 
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, Comparator.comparingInt(o -> o[0]));

        int maxLIS = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (wires[j][1] < wires[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        System.out.println(N - maxLIS); 
    }
}
