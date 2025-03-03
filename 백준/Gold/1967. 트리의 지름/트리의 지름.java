import java.util.*;
import java.io.*;

public class Main {
    static int N, maxDist = 0, farthestNode = 0;
    static List<Node>[] graph;
    static boolean[] visited;

    static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) { 
            System.out.println(0);
            return;
        }

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) { 
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[A].add(new Node(B, W));
            graph[B].add(new Node(A, W));
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    static void dfs(int node, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        visited[node] = true;
        for (Node next : graph[node]) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}
