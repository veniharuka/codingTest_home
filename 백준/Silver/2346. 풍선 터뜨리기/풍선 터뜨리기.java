import java.io.*;
import java.util.*;

public class Main {
    static class Balloon {
        int idx, move;
        Balloon(int idx, int move) {
            this.idx = idx;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int move = Integer.parseInt(st.nextToken());
            deque.addLast(new Balloon(i, move));
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Balloon now = deque.pollFirst();
            sb.append(now.idx).append(" ");

            if (deque.isEmpty()) break;

            int move = now.move;
            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(move); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
