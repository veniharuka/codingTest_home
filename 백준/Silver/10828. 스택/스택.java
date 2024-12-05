import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); 
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push": // push X
                    stack.push(Integer.parseInt(command[1]));
                    break;

                case "pop": // pop
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;

                case "size": // size
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty": // empty
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "top": // top
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                    break;

                default:
                    break;
            }
        }

        System.out.print(sb);
    }
}
