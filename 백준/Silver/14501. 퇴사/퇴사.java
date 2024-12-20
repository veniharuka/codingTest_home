import java.io.*;
import java.util.*;

public class Main {  // 백준에서는 클래스 이름을 Main으로 해야 합니다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];  // N+2 크기로 변경
        
        // 입력 (1일부터 시작하도록 인덱스 조정)
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[i] : i일까지 일했을 때 얻을 수 있는 최대 수익
        for(int i = N; i > 0; i--) {  // 뒤에서부터 계산
            int next = i + T[i];  // 상담이 끝나는 날
            
            if(next > N + 1) {  // 상담이 퇴사일을 넘어가는 경우
                dp[i] = dp[i+1];
            } else {  // 상담이 가능한 경우
                dp[i] = Math.max(dp[i+1], P[i] + dp[next]);
            }
        }
        
        System.out.println(dp[1]);  // 1일부터 시작했을 때의 최대 수익
    }
}