import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger count = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        sb.append(count).append("\n");

        if (N <= 20) {
            hanoi(N, 1, 2, 3);
        }
        
        System.out.print(sb);
    }

    static void hanoi(int n, int from, int mid, int to) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(n - 1, from, to, mid);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, mid, from, to);
    }
}