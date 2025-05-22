import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        int[] coins = {25, 10, 5, 1};
        
        for (int t = 0; t < T; t++) {
            int C = Integer.parseInt(br.readLine());
            
            for (int i = 0; i < 4; i++) {
                int count = C / coins[i];
                sb.append(count).append(" ");
                C %= coins[i]; 
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}