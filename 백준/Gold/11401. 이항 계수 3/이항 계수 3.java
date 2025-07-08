import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] fact;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long denominator = (fact[K] * fact[N - K]) % MOD;
        long answer = (fact[N] * modInverse(denominator, MOD)) % MOD;
        System.out.println(answer);
    }

    static long modInverse(long a, int mod) {
        return pow(a, mod - 2, mod);
    }

    static long pow(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
