import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long result = binomialCoefficient(n - 1, k - 1);
        System.out.println(result);
    }

    static long binomialCoefficient(int n, int r) {
        if (r == 0 || r == n) {
            return 1;
        }

        if (r > n - r) {
            r = n - r;
        }
        
        long result = 1;

        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        
        return result;
    }
}