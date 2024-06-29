import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.startsWith("1")) {
                String[] arr = s.split(" ");
                stack.add(Integer.parseInt(arr[1]));
            } else {
                stackProgram(Integer.parseInt(s));
            }
        }
        System.out.println(sb.toString());
    }

    public static void stackProgram(int order) {
        switch(order) {
            case 2:
                if(stack.empty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.pop() + "\n");
                }
                break;
            case 3:
                sb.append(stack.size() + "\n");
                break;
            case 4:
                if(stack.empty()) {
                    sb.append(1 + "\n");
                } else {
                    sb.append(0 + "\n");
                }
                break;
            case 5:
                if(stack.empty()) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(stack.peek() + "\n");
                }
        }
    }
}