import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] base = {{1, 1}, {1, 0}};
        long[][] result = pow(base, n);

        System.out.println(result[0][1]);
    }

    static long[][] pow(long[][] a, long n) {
        if (n == 1) {
            return a;
        }
        long[][] half = pow(a, n / 2);
        long[][] temp = multiply(half, half);
        if (n % 2 == 1) {
            temp = multiply(temp, a);
        }
        return temp;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
