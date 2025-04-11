import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] inorder;
    static List<Integer>[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = (int)Math.pow(2, K) - 1; 
        inorder = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        tree = new ArrayList[K];
        for (int i = 0; i < K; i++) {
            tree[i] = new ArrayList<>();
        }

        reconstruct(0, nodeCount - 1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            for (int node : tree[i]) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }

    static void reconstruct(int start, int end, int depth) {
        if (depth >= K || start > end) return;
        
        int mid = (start + end) / 2; 
        tree[depth].add(inorder[mid]); 

        reconstruct(start, mid - 1, depth + 1); 
        reconstruct(mid + 1, end, depth + 1);  
    }
}