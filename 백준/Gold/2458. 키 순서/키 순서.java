import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 

        graph = new boolean[N+1][N+1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true; // a는 b보다 키가 작다
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int count = 0;
            
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }

            if (count == N - 1) {
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}