import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        
        int findDigits = n;
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int returnNum = 0;
        
        //Find digits code
        //https://www.edureka.co/community/2687/how-can-i-separate-the-digits-of-an-int-number-in-java#:~:text=You%20can%20convert%20a%20number,%3A%20String%5B%5D%20digits2%20%3D%20number.
        while (findDigits > 0) {
            stack.push( findDigits % 10 );
            findDigits = findDigits / 10;
        }
        
        while(!stack.isEmpty()){
            int x = stack.pop();
            if (x != 0 && n  % x == 0) {
               returnNum += 1;
            }
        }
        return returnNum;
        
    }   

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
