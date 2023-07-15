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

    public static int getTheRank(List<Integer> givenArray, Integer k) {
    int currentCount = 1;
    for (int i = 0; i < givenArray.size(); i++) {
        if (k.equals(givenArray.get(i))) {
            return currentCount;
        } else if (k < givenArray.get(i) && (i == givenArray.size() - 1 || k > givenArray.get(i + 1))) {
            return currentCount + 1;
        } else if (i < givenArray.size() - 1 && givenArray.get(i).equals(givenArray.get(i + 1))) {
            continue;
        } else if (k < givenArray.get(i)) {
            currentCount += 1;
        }
    }
    return currentCount;
}
    
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> returnList = new ArrayList<>();
        int currentRank = 0;
        for (int i = 0; i < player.size(); i++){
            currentRank = new Result().getTheRank(ranked, player.get(i));
            returnList.add(currentRank);
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
