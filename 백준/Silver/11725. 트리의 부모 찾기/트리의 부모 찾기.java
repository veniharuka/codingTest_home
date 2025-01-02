import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 트리 구조를 인접 리스트로 표현
        ArrayList<Integer>[] tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // 트리 입력 받기
        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            tree[n1].add(n2);
            tree[n2].add(n1);
        }
        
        // 부모 노드를 저장할 배열
        int[] parents = new int[N + 1];
        
        // BFS로 트리 탐색
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트노드부터 시작
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next : tree[current]) {
                if(parents[next] == 0) { // 아직 부모가 설정되지 않은 노드
                    parents[next] = current;
                    queue.offer(next);
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        System.out.print(sb);
    }
}