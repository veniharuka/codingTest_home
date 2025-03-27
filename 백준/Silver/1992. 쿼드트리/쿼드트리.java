import java.io.*;

public class Main {
    static int[][] image;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        image = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                image[i][j] = line.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(result);
    }

    static void quadTree(int x, int y, int size) {
        if (isUniformColor(x, y, size)) {
            result.append(image[x][y]);
            return;
        }

        result.append("(");

        int newSize = size / 2;
        quadTree(x, y, newSize);                    
        quadTree(x, y + newSize, newSize);          
        quadTree(x + newSize, y, newSize);          
        quadTree(x + newSize, y + newSize, newSize);

        result.append(")");
    }

    static boolean isUniformColor(int x, int y, int size) {
        int color = image[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (image[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}