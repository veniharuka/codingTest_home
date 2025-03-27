import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

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

        System.out.println(white);
        System.out.println(blue);
    }

    static void divideAndConquer(int x, int y, int size) {
        if (isUniformColor(x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        divideAndConquer(x, y, newSize);                   
        divideAndConquer(x, y + newSize, newSize);          
        divideAndConquer(x + newSize, y, newSize);         
        divideAndConquer(x + newSize, y + newSize, newSize);
    }

    static boolean isUniformColor(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}