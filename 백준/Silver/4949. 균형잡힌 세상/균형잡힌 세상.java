import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;  // 종료 조건
            
            sb.append(isValid(line) ? "yes" : "no").append('\n');
        }
        
        System.out.print(sb);
    }
    
    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            // 여는 괄호일 경우 스택에 추가
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            // 닫는 괄호일 경우 처리
            else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            // 다른 문자는 무시
        }
        
        return stack.isEmpty();  // 스택이 비어있어야 균형잡힌 문자열
    }
}