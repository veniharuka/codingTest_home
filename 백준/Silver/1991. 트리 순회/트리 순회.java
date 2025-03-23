import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        char data;
        Node left;
        Node right;
        
        Node(char data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        tree = new Node[26]; 
        
        for (int i = 0; i < 26; i++) {
            tree[i] = new Node((char)('A' + i));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.') {
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append('\n');
        inorder(tree[0]);
        
        sb.append('\n');
        postorder(tree[0]);
        
        System.out.println(sb.toString());
    }
    static void preorder(Node node) {
        if (node == null) return;
        
        sb.append(node.data); 
        preorder(node.left);  
        preorder(node.right); 
    }

    static void inorder(Node node) {
        if (node == null) return;
        
        inorder(node.left);   
        sb.append(node.data); 
        inorder(node.right);  
    }

    static void postorder(Node node) {
        if (node == null) return;
        
        postorder(node.left);  
        postorder(node.right);
        sb.append(node.data); 
    }
}