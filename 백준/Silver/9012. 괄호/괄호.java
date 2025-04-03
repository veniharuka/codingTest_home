import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < T; i++) {
            String ps = br.readLine();
            sb.append(isValidPS(ps) ? "YES" : "NO").append("\n");
        }
        
        System.out.print(sb);
    }

    public static boolean isValidPS(String ps) {
        int count = 0;
        
        for (int i = 0; i < ps.length(); i++) {
            char c = ps.charAt(i);        
            if (c == '(') {
                count++; 
            } else if (c == ')') {
                count--;  
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}