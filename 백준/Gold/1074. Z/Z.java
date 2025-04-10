import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int result = 0;

        while (N > 0) {
            int size = (int) Math.pow(2, N - 1); 
            int area = size * size; 
 
            if (r < size && c < size) {
            } else if (r < size && c >= size) {
                result += area;
                c -= size;
            } else if (r >= size && c < size) {
                result += area * 2;
                r -= size;
            } else {
                result += area * 3;
                r -= size;
                c -= size;
            }
            
            N--;
        }
        
        System.out.println(result);
    }
}