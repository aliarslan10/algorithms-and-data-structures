import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 *
 * Example :
 * s = "cdcd", output = 5
 * s = "ifailuhkqq", output = 3
 * s = "kkkk", output = 10
 *
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 *
 * This solution open to contribution if you have better approach **** https://github.com/aliarslan10
 */

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = ResultSherlockAndAnagrams.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();

     /*
        //For testing on local from intellij
        System.out.println(ResultSherlockAndAnagrams.sherlockAndAnagrams("abba"));
        System.out.println(ResultSherlockAndAnagrams.sherlockAndAnagrams("abcd"));
        System.out.println("---");
        System.out.println(ResultSherlockAndAnagrams.sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(ResultSherlockAndAnagrams.sherlockAndAnagrams("kkkk"));
        System.out.println("---");
        System.out.println(ResultSherlockAndAnagrams.sherlockAndAnagrams("cdcd"));
        */
    }
}


class ResultSherlockAndAnagrams {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        // Write your code here

        int length = s.length();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = 1; i+j < length+1; j++) {
                String subStr = s.substring(i, i+j);
                char[] subArray = subStr.toCharArray();
                Arrays.sort(subArray);
                String sortedStr = new String(subArray);
                Integer count = hashMap.get(sortedStr);
                if (count == null) {
                    hashMap.put(sortedStr, 1);
                } else {
                    hashMap.put(sortedStr, ++count);
                }
            }
        }

        int result = 0;
        for (Integer count : hashMap.values()) {
            result += (count * (count - 1)) / 2;
        }

        return result;
    }

}