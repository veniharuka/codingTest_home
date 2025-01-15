import java.util.*;
import java.io.*;
public class Main{
    static int w,h;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int islands;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            if (w == 0 && h == 0) break;
            graph = new int[h][w];
            visited = new boolean[h][w];
            
            //그래프 입력받기
            for(int i=0; i<h; i++){
                String[] line = br.readLine().split(" ");
                for(int j=0; j<w; j++){
                    graph[i][j] = Integer.parseInt(line[j]);
                }
            }  
            islands = 0;
            // 섬의 개수 세기
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(!visited[i][j] && graph[i][j]==1){
                        islands++;
                        bfs(i,j);
                    }
                }
            }
            System.out.println(islands);
        }
    }
    
    static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<8; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=0 && ny>=0 && nx<h && ny<w){
                    if(!visited[nx][ny] && graph[nx][ny]==1){
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
        }
    }
}