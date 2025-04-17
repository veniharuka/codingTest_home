import java.io.*;

public class Main {
    static char[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        visited = new boolean[input.length];
        
        solve(0, input.length - 1);
        
        System.out.print(sb.toString());
    }
    
    static void solve(int left, int right) {
        if (left > right) return;
        
        int idx = left;
        for (int i = left; i <= right; i++) {
            if (input[idx] > input[i]) {
                idx = i;
            }
        }
        
        visited[idx] = true;

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) {
                sb.append(input[i]);
            }
        }
        sb.append("\n");
        solve(idx + 1, right);
        solve(left, idx - 1);
    }
}