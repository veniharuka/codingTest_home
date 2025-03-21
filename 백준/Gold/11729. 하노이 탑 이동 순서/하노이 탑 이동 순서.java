import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        int N = Integer.parseInt(br.readLine());
        
        count = (1 << N) - 1;
        sb.append(count).append('\n');
        hanoi(N, 1, 2, 3);
        
        System.out.println(sb.toString());
    }

    static void hanoi(int n, int from, int aux, int to) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }
        
        hanoi(n - 1, from, to, aux);
        sb.append(from).append(' ').append(to).append('\n');
        hanoi(n - 1, aux, from, to);
    }
}