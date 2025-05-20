import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Integer[] bIndices = new Integer[N];
        for (int i = 0; i < N; i++) {
            bIndices[i] = i;
        }

        Arrays.sort(bIndices, (i, j) -> B[j] - B[i]);
        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[bIndices[i]];
        }
        
        System.out.println(S);
    }
}