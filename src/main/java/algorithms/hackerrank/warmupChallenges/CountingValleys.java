package algorithms.hackerrank.warmupChallenges;

import java.io.*;

/**
 * A valley is a sequence of consecutive steps below sea level
 * If it starts from see level and goes down, then if it returns again to sea level, this is the valley
 * In this problem we will count the number of the valley with given "UDDDUDUU" text
 * D : Downhill
 * U : Uphill
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */

public class CountingValleys {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = ResultCountingValleys.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        /* For testing on local from intellij
        int result = ResultCountingValleys.countingValleys(4, "DDUU");
        System.out.println(result);
         */
    }
}

class ResultCountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {

        char[] charArray = path.toCharArray();
        int numberOfValley = 0;
        int currentLevel   = 0;

        for (int i = 0; i < steps; i++) {
            if (charArray[i] == 'U')
                currentLevel++;
            if (charArray[i] == 'D')
                currentLevel--;

            if (currentLevel == 0 && charArray[i] == 'U')
                numberOfValley++;
        }

        return numberOfValley;
    }
}
