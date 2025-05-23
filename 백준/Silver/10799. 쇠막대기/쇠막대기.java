import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int result = 0; 
        int openCount = 0; 
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openCount++;
            } 

            else {
                openCount--;  
                if (input.charAt(i - 1) == '(') {
                    result += openCount; 
                } 
                else {
                    result += 1;  
                }
            }
        }
        
        System.out.println(result);
    }
}