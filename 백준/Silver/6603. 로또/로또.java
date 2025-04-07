import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] S;
    static int[] lotto = new int[6];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            
            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < k; i++) {
            lotto[depth] = S[i];         
            dfs(i + 1, depth + 1); 
        }
    }
}