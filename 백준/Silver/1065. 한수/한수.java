import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(hansu(n));
    }

    public static int hansu(int n) {
        if (n < 100) return n; // 100 미만은 모두 한수

        int hansu = 99; // 100 이상부터 계산
        for (int i = 100; i <= n; i++) {
            int hundredDigit = i / 100;
            int tenDigit = (i / 10) % 10;
            int onesDigit = i % 10;

            // 등차수열 조건 확인
            if ((hundredDigit - tenDigit) == (tenDigit - onesDigit)) {
                hansu++;
            }
        }
        return hansu;
    }
}
