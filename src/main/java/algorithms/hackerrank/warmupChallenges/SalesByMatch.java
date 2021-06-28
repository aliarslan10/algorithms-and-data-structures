package algorithms.hackerrank.warmupChallenges;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 * int n: the number of socks in the pile
 * int ar[n]: the colors of each sock
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        /* For testing on local from intellij
        List<Integer> ar = Stream.of("6 5 2 3 5 2 2 1 1 5 1 3 3 3 5".replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt).collect(toList());
        Result.sockMerchant(15, ar);
         */
    }
}

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Set<Integer> items = new HashSet<>();
        int pair = 0;
        for (int i = 0; i < n; i++) {
            if (!items.add(ar.get(i))) {
                pair++;
                items.remove(ar.get(i));
            }
        }
        return pair;
    }
}

