import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minPaint = Integer.MAX_VALUE;

        for (int x = 0; x <= N - 8; x++) {
            for (int y = 0; y <= M - 8; y++) {
                int cntW = 0, cntB = 0;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                        char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';
                        if (board[x + i][y + j] != expectedW) cntW++;
                        if (board[x + i][y + j] != expectedB) cntB++;
                    }
                }
                minPaint = Math.min(minPaint, Math.min(cntW, cntB));
            }
        }
        System.out.println(minPaint);
    }
}
