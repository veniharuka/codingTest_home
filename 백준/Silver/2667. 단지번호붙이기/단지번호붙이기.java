import java.util.*;
import java.io.*;
public class Main{
   static int[][] graph;
   static boolean[][] visited;
   static int[] dx = {0, 1, 0, -1}; // 상하좌우 이동
   static int[] dy = {1, 0, -1, 0};
   static int map;  // map을 전역 변수로 선언
   
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       map = Integer.parseInt(br.readLine());
       
       graph = new int[map][map];
       visited = new boolean[map][map];
       
       // graph 입력
       for(int i=0; i<map; i++){
           String input = br.readLine();
           for(int j=0; j<map; j++){
               graph[i][j] = input.charAt(j) - '0';
           }
       }
       
       int houseCount = 0; // 집의 개수
       int[] houseWidth = new int[map * map];  // 최대 크기로 배열 초기화
       
       // n,m을 map으로 수정
       for (int i = 0; i < map; i++) {
           for (int j = 0; j < map; j++) {
               if (graph[i][j] == 1 && !visited[i][j]) {
                   houseWidth[houseCount] = bfs(i, j); // 현재 단지의 너비를 배열에 저장
                   houseCount++;
               }
           }
       }
       
       // 오름차순 정렬
       Arrays.sort(houseWidth, 0, houseCount);
       
       // 결과 출력
       System.out.println(houseCount);  // 총 단지 수
       for(int i=0; i<houseCount; i++){  // 각 단지의 집 수 출력
           System.out.println(houseWidth[i]);
       }
   }
   
   static int bfs(int x, int y){
       Queue<int[]> q = new ArrayDeque<>();
       q.add(new int[] {x, y});
       visited[x][y] = true;
       int width = 1;  // 시작점도 포함해야 하므로 1로 초기화
       
       while(!q.isEmpty()){
           int[] current = q.poll();
           
           for (int i = 0; i < 4; i++) {
               int nx = current[0] + dx[i];
               int ny = current[1] + dy[i];
               
               if (nx >= 0 && ny >= 0 && nx < map && ny < map) {
                   if (graph[nx][ny] == 1 && !visited[nx][ny]) {
                       q.add(new int[] {nx, ny});
                       visited[nx][ny] = true;
                       width++;  // 새로운 집을 발견할 때마다 증가
                   }
               }
           }
       }
       return width;  // 단지 내 집의 수 반환
   }
}