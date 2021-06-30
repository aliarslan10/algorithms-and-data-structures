package algorithms.hackerrank.warmupChallenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting position to the last cloud.
 * It is always possible to win the game.
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = ResultJumpingOnTheClouds.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

     /* For testing on local from intellij
        int result = ResultJumpingOnTheClouds.jumpingOnClouds(Arrays.asList(0, 0, 0, 1, 0, 1));
        System.out.println(result);
     */
    }
}

class ResultJumpingOnTheClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        // Write your code here
        int path = 0;
        for (int step = 0; step < c.size(); step++) {
            if ((step+2 < c.size()) && c.get(step+2) != 1) {
                path++;
                step++;
            } else if ((step+1 < c.size()) && c.get(step+1) != 1) {
                path++;
            }
        }
        return path;
    }
}
