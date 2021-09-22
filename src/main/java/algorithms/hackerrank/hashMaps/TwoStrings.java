package algorithms.hackerrank.hashMaps;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * https://github.com/aliarslan10
 *
 * Given two strings, determine if they share a common substring. A substring may be as small as one character.
 * s1 = "and", s2 = "art" => Result : YES
 * s1 = "be",  s2 = "cat" => Result : NO
 *
 * https://www.hackerrank.com/challenges/two-strings/problem
 */

public class TwoStrings {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = ResultTwoStrings.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

         /* For testing on local from intellij
        System.out.println(ResultTwoStrings.twoStrings("wouldyoulikefries", "abcabcabcabcabcabc"));
        */
    }
}

class ResultTwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        Set<Character> stringSet = new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            stringSet.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            if (!stringSet.add(s2.charAt(i))) {
                return "YES";
            }
            stringSet.remove(s2.charAt(i));
        }

        return "NO";
    }
}