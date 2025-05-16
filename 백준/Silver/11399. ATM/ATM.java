import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] times = new int[N];
        
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times);
        
        int total = 0; 
        int current = 0; 
        
        for (int i = 0; i < N; i++) {
            current += times[i]; 
            total += current;   
        }
        
        System.out.println(total);
    }
}