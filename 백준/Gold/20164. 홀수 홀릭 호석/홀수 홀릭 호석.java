import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        solve(N, countOdd(N));
        System.out.println(min + " " + max);
    }

    static void solve(String num, int oddCount) {
        if (num.length() == 1) {
            min = Math.min(min, oddCount);
            max = Math.max(max, oddCount);
            return;
        }

        if (num.length() == 2) {
            int sum = (num.charAt(0) - '0') + (num.charAt(1) - '0');
            String newNum = Integer.toString(sum);
            solve(newNum, oddCount + countOdd(newNum));
            return;
        }

        for (int i = 1; i < num.length(); i++) {
            for (int j = i + 1; j < num.length(); j++) {

                String part1 = num.substring(0, i);
                String part2 = num.substring(i, j);
                String part3 = num.substring(j);

                int sum = Integer.parseInt(part1) + Integer.parseInt(part2) + Integer.parseInt(part3);
                String newNum = Integer.toString(sum);

                solve(newNum, oddCount + countOdd(newNum));
            }
        }
    }

    static int countOdd(String num) {
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}