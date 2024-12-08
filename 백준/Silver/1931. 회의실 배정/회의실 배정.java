import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
                
        int confCnt = 0; 
        int[][] confTime = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            confTime[i][0] = Integer.parseInt(st.nextToken()); 
            confTime[i][1] = Integer.parseInt(st.nextToken()); 
        }

        Arrays.sort(confTime, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0]; 
            return a[1] - b[1]; 
        });

            
        int lastEndTime =0;
        for(int i=0; i<n; i++){
            if(confTime[i][0] >=lastEndTime){
                confCnt++;
                lastEndTime = confTime[i][1];
            }
        }
        System.out.println(confCnt);
       }
}
