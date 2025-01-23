import java.util.*;
import java.io.*;

public class Main{
    static int[][] graph;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houses = Integer.parseInt(br.readLine());
        graph = new int[houses][3];
        dp = new int[houses][3];
        // RGB 하우스 그래프 입력
        for(int h=0; h<houses; h++){
            String[] line = br.readLine().split(" ");
            for(int s=0; s<3; s++){
                graph[h][s] = Integer.parseInt(line[s]);
            }
        }
        // 첫 번째 집의 경우는 앞의 선택이 없으니 제약 없이 다 넣을 수 있다.
        dp[0][0] = graph[0][0];
        dp[0][1] = graph[0][1];
        dp[0][2] = graph[0][2];
        // 첫 번째에 0 위치면 2번째 집은 1,2 색만 선택 가능
        for (int i = 1; i < houses; i++) {
            dp[i][0] = graph[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = graph[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = graph[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        int result = Math.min(dp[houses - 1][0], Math.min(dp[houses - 1][1], dp[houses - 1][2]));
        System.out.println(result);
    }
}