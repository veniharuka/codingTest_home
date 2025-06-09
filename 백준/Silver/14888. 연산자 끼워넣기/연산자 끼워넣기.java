import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, numbers[0]);
        
        System.out.println(maxResult);
        System.out.println(minResult);
    }
    
    static void dfs(int depth, int currentResult) {
        if (depth == N) {
            maxResult = Math.max(maxResult, currentResult);
            minResult = Math.min(minResult, currentResult);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                
                int nextResult = 0;
                if (i == 0) { 
                    nextResult = currentResult + numbers[depth];
                } else if (i == 1) { 
                    nextResult = currentResult - numbers[depth];
                } else if (i == 2) { 
                    nextResult = currentResult * numbers[depth];
                } else if (i == 3) {
                    nextResult = currentResult / numbers[depth];
                }
                
                dfs(depth + 1, nextResult);
                operators[i]++;
            }
        }
    }
}