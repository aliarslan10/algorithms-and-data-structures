package algorithms.hackerrank.warmupChallenges;

import java.io.*;

/**
 * There is a string "s" of lowercase English letters that is repeated infinitely many times. Given an integer "n",
 * find and print the number of letter a's in the first "n" letters of the infinite string.
 * https://www.hackerrank.com/challenges/repeated-string/problem
 */

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = ResultRepeatedString.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

         /* For testing on local from intellij
        long result = ResultRepeatedString.repeatedString("ababa", 3);
        System.out.println(result);
        */
    }
}

class ResultRepeatedString {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here

        long aCount = 0;
        long strSize= s.length();
        long left = n % strSize;

        if (s.contains("a") && strSize == 1) {
            return n;
        }

        if (s.contains("a")) {
            if (n > strSize) {
                for (int i = 0; i < strSize; i++) {
                    if (s.charAt(i) == 'a') {
                        aCount++;
                    }
                }
                aCount = aCount * (n/strSize);
            }

            for (int i = 0; i < left; i++) {
                if (s.charAt(i) == 'a') {
                    aCount++;
                }
            }
        }

        return aCount;
    }
}