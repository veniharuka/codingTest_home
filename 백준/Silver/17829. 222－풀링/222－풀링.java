import java.io.*;
import java.util.*;

public class Main {
    static int[][] matrix;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
 
        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = pooling(0, 0, N);
        System.out.println(result);
    }

    static int pooling(int x, int y, int size) {
        if (size == 2) {
            int[] values = new int[4];
            values[0] = matrix[x][y];
            values[1] = matrix[x][y + 1];
            values[2] = matrix[x + 1][y];
            values[3] = matrix[x + 1][y + 1];

            Arrays.sort(values);
            return values[2];
        }

        int newSize = size / 2;
        int[] pooled = new int[4];

        pooled[0] = pooling(x, y, newSize);                 
        pooled[1] = pooling(x, y + newSize, newSize);      
        pooled[2] = pooling(x + newSize, y, newSize);          
        pooled[3] = pooling(x + newSize, y + newSize, newSize);

        Arrays.sort(pooled);
        return pooled[2]; 
    }
}