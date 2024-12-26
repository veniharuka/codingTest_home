import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[] input = new int[T];
        int maxN = 0;

        // 입력값 저장 및 최대 n 찾기
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (input[i] > maxN) maxN = input[i];
        }

        // DP 배열 초기화
        int[] count0 = new int[maxN + 1];
        int[] count1 = new int[maxN + 1];

        count0[0] = 1;
        count1[0] = 0;

        if (maxN >= 1) {
            count0[1] = 0;
            count1[1] = 1;
        }

        // DP 점화식 계산
        for (int i = 2; i <= maxN; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        // 결과 출력
        for (int n : input) {
            sb.append(count0[n]).append(" ").append(count1[n]).append("\n");
        }

        System.out.print(sb);
    }
}
