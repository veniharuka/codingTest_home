import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        int A = 5 * 60; 
        int B = 1 * 60;  
        int C = 10;      

        if (T % 10 != 0) {
            System.out.println(-1);
            return;
        }

        int countA = T / A; 
        T %= A;             
        
        int countB = T / B;  
        T %= B;           
        
        int countC = T / C; 
        
        System.out.println(countA + " " + countB + " " + countC);
    }
}