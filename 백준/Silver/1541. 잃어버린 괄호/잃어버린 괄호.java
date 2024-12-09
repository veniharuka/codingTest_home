import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] subtractParts = input.split("-");
        int result = 0;
        
        for (int i = 0; i < subtractParts.length; i++) {
            String[] addParts = subtractParts[i].split("\\+");
            int sum = 0;
            for (String num : addParts) {
                sum += Integer.parseInt(num); 
            }
            
            if (i == 0) {
                result += sum; 
            } else {
                result -= sum; 
            }
        }

        System.out.println(result);
    }
}