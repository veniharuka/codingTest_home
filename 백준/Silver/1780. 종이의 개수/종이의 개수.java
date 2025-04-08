import java.io.*;
import java.util.*;

public class Main {
    static int[][] paper;
    static int minusOne = 0; 
    static int zero = 0;  
    static int one = 0;     
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divideAndConquer(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void divideAndConquer(int x, int y, int size) {
        if (isUniform(x, y, size)) {
            int value = paper[x][y];
            if (value == -1) minusOne++;
            else if (value == 0) zero++;
            else one++;
            return;
        }
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divideAndConquer(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
    static boolean isUniform(int x, int y, int size) {
        int value = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}