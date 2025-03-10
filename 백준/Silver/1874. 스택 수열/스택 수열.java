import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        
        int num = 1;
        boolean possible = true;
        
        for (int i = 0; i < n; i++) {
            int target = sequence[i];
            
            while (num <= target) { 
                stack.push(num++);
                sb.append("+\n");
            }
            
            if (stack.peek() == target) { 
                stack.pop();
                sb.append("-\n");
            } else { 
                possible = false;
                break;
            }
        }
        
        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
