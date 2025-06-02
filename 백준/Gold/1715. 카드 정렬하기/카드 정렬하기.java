import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }
        
        long totalComparisons = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            
            long merged = first + second;
            totalComparisons += merged;  

            pq.offer(merged);
        }
        
        System.out.println(totalComparisons);
    }
}