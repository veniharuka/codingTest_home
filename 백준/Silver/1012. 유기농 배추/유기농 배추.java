import java.util.*;
import java.io.*;

public class Main{

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
    static int[] dy = {1, 0, -1, 0};
    static int width;
    static int length; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase =Integer.parseInt(br.readLine());
        for(int A=0; A<testCase; A++){
            
        String[] input= br.readLine().split(" ");
        width = Integer.parseInt(input[0]);
        length =Integer.parseInt(input[1]);
        int cabbage = Integer.parseInt(input[2]);
            
            
        graph = new int[width][length];
        visited = new boolean[width][length];
        // 배추지렁이
        int insects =0; 
            
        // 그래프 입력 처리
        for (int i = 0; i < cabbage; i++) {
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            graph[x][y] = 1;
        }
        for (int a = 0; a < width; a++) {
            for (int b = 0; b < length; b++) {
                if (graph[a][b] == 1 && !visited[a][b]) {
                    insects ++;
                    bfs(a, b); 
                }
            }
        }
         // 각 벌레의 수 출력
          System.out.println(insects);
      
            
        }
        
        
    }
    static void bfs(int x, int y){
        Queue<int[]> q =new ArrayDeque<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        
        
        while(!q.isEmpty()){
            int[] current = q.poll();
            
            for(int i=0; i<4; i++){
                int nx = current[0]+dx[i];
                int ny = current[1]+dy[i];
                if(nx>=0 && ny>=0 && nx<width && ny<length){
                    if(graph[nx][ny]==1 && !visited[nx][ny]){
                        q.add(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

    }
}