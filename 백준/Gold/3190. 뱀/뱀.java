import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); 
        int K = Integer.parseInt(br.readLine());  

        int[][] board = new int[N+1][N+1];
 
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row][col] = 1;  
        }
        
        int L = Integer.parseInt(br.readLine());

        Map<Integer, Character> directions = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directions.put(time, dir);
        }

        int time = 0;  
        int dir = 1; 

        Deque<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{1, 1}); 
        board[1][1] = 2; 
        
        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (nx <= 0 || nx > N || ny <= 0 || ny > N || board[nx][ny] == 2) {
                break;
            }

            boolean hasApple = (board[nx][ny] == 1);

            snake.offerLast(new int[]{nx, ny});
            board[nx][ny] = 2;

            if (!hasApple) {
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            if (directions.containsKey(time)) {
                char turn = directions.get(time);
                if (turn == 'L') {
                    dir = (dir + 3) % 4;  
                } else { 
                    dir = (dir + 1) % 4;  
                }
            }
        }
        
        System.out.println(time);
    }
}