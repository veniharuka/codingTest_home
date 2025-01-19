import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 설탕 무게 입력
        
        int result = -1; // 초기값은 -1로 설정
        
        // 5kg 봉지의 최대 개수부터 시작
        for (int five = N / 5; five >= 0; five--) {
            int remainder = N - (5 * five);
            
            // 남은 무게가 3으로 나누어떨어지면
            if (remainder % 3 == 0) {
                result = five + (remainder / 3);
                break;
            }
        }
        
        System.out.println(result);
    }
}