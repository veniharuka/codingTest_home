import java.util.*;
import java.io.*;
public class Main{
   static int[] dx = {-1,0,1,0};
   static int[] dy = {0,1,0,-1};  
   // 전역변수로 선언해서 모든 함수에서 접근 가능하게 함
   static int length, width;
   static int[][] graph;
   static boolean[][] visited;
   static int safetyArea = 0;
   
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String[] input = br.readLine().split(" ");
       length = Integer.parseInt(input[0]);
       width = Integer.parseInt(input[1]);
       graph = new int[length][width];
       
       // 그래프 입력
       for(int i=0; i<length; i++){
           String[] line = br.readLine().split(" ");
           for(int j=0; j<width; j++){
               graph[i][j] = Integer.parseInt(line[j]);
           }
       }
       
       dfs(0);  // 벽 세우기 시작
       
       System.out.println(safetyArea);
   }
   
   // 벽을 3개 세우는 함수
   static void dfs(int count) {
       if(count == 3) {  // 벽 3개를 다 세웠으면
           bfs();  // 바이러스 퍼뜨리기 시작
           return;
       }
       
       for(int i=0; i<length; i++) {
           for(int j=0; j<width; j++) {
               if(graph[i][j] == 0) {
                   graph[i][j] = 1;  // 벽 세우기
                   dfs(count+1);
                   graph[i][j] = 0;  // 벽 제거
               }
           }
       }
   }
   
   static void bfs() {
       Queue<int[]> q = new ArrayDeque<>();
       // 그래프 복사
       int[][] copyGraph = new int[length][width];
       visited = new boolean[length][width];
       
       for(int i=0; i<length; i++) {
           copyGraph[i] = graph[i].clone();
       }
       
       // 바이러스 위치 찾아서 큐에 넣기
       for(int i=0; i<length; i++) {
           for(int j=0; j<width; j++) {
               if(copyGraph[i][j] == 2) {
                   q.add(new int[] {i,j});
                   visited[i][j] = true;
               }
           }
       }
       
       // 바이러스 퍼뜨리기
       while(!q.isEmpty()) {
           int[] current = q.poll();
           
           for(int i=0; i<4; i++) {
               int ny = current[0] + dy[i];
               int nx = current[1] + dx[i];
               
               if(nx>=0 && ny>=0 && nx<width && ny<length) {
                   if(!visited[ny][nx] && copyGraph[ny][nx] == 0) {
                       copyGraph[ny][nx] = 2;
                       q.add(new int[] {ny,nx});
                       visited[ny][nx] = true;
                   }
               }
           }
       }
       
       // 안전 영역 계산
       int count = 0;
       for(int i=0; i<length; i++) {
           for(int j=0; j<width; j++) {
               if(copyGraph[i][j] == 0) {
                   count++;
               }
           }
       }
       
       safetyArea = Math.max(safetyArea, count);
   }
}