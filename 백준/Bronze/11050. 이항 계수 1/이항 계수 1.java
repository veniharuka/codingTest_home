import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(binomial(N, K));
    }

    static int binomial(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    static int factorial(int x) {
        int res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }
}
