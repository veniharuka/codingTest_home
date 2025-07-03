import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long B;
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] result = pow(A, B);

        StringBuilder sb = new StringBuilder();
        for (int[] row : result) {
            for (int val : row) {
                sb.append(val % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static int[][] pow(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }
        int[][] half = pow(matrix, exp / 2);
        int[][] temp = multiply(half, half);
        if (exp % 2 == 1) {
            temp = multiply(temp, matrix);
        }
        return temp;
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += (a[i][k] * b[k][j]);
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }
}
