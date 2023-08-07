import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        // k is the jump distance
        // if c[i] = 0 cumulus cloud
        // if c[i] = 1 thunderhead cloud
        // if move is to a thenderhead, move takes 2 energy, if move is to a cumulus, it takes 1 energy.
        
        
        int curEnergy = 100;
        int curCloud = k;
        
        
        while(curCloud % c.length != 0){
            if (c[curCloud % c.length] == 1){
                curEnergy -= 3;
            }
            else if(c[curCloud % c.length] == 0){
                curEnergy -= 1;
            }
            
            curCloud += k;
        }
        
        //since loop ends before the last jump concludes, 1 more calculation.
        if (c[0] == 1){
            curEnergy -= 3;
        }else if(c[0] == 0){
            curEnergy -= 1;
        }
        
        
        return curEnergy;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
