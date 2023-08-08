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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    List<Integer> returnList = new ArrayList<>();
    
    TreeSet<Integer> mergedList = new TreeSet<>(ranked); //Remove duplicates, and order at the same time.
    //Also helps with reordering while adding the scores in the for loop.
    
    //I will search the loop using a counter so that I won't be returning to the start everytime.
    //int counter = 0;
    //for (int score:player) {
    //    mergedList.add(score);
     //   List<Integer> mergedListAsList = new ArrayList<>(mergedList); //For doing binary search
    //    Collections.reverse(mergedListAsList);
    //    for (int i=counter; i<mergedListAsList.size(); i++){
    //        if (mergedListAsList.get(i) == score){
    //                returnList.add(i+1);
     //       }
     //   }
    //}
    
    // The approach above works, however it still gets the time exceeded error.
    for (int score : player) {
        mergedList.add(score);
        int playerRank = mergedList.size() - mergedList.headSet(score, true).size();
        returnList.add(playerRank + 1);
    }
    
    return returnList;
    
}
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}