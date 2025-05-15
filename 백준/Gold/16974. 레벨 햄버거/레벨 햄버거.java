import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        long[] length = new long[N + 1];
        long[] patty = new long[N + 1];

        length[0] = 1;
        patty[0] = 1; 
        
        for (int i = 1; i <= N; i++) {
            length[i] = 2 * length[i - 1] + 3; 
            patty[i] = 2 * patty[i - 1] + 1;   
        }

        long result = countPatty(N, X, length, patty);
        System.out.println(result);
    }

    static long countPatty(int level, long x, long[] length, long[] patty) {
        if (level == 0) {
            return x > 0 ? 1 : 0;
        }
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 0;
        }
        if (x <= 1 + length[level - 1]) {
            return countPatty(level - 1, x - 1, length, patty);
        }
        if (x == 1 + length[level - 1] + 1) {
            return patty[level - 1] + 1;
        }
        if (x < length[level]) {
            return patty[level - 1] + 1 + countPatty(level - 1, x - (1 + length[level - 1] + 1), length, patty);
        }
        return patty[level];
    }
}