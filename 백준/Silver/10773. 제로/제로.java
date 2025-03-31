import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (!numbers.isEmpty()) {
                    numbers.remove(numbers.size() - 1);
                }
            } 
            else {
                numbers.add(num);
            }
        }
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        System.out.println(sum);
    }
}