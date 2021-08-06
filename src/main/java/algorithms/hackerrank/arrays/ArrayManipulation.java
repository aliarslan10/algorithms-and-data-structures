package algorithms.hackerrank.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to
 * each the array element between two given indices, inclusive. Once all operations have been performed,
 * return the maximum value in the array.
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class ArrayManipulation {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = ResultArrayManipulation.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        /* For testing on local from intellij
        // First Test
        List<Integer> q1 = Arrays.asList(1, 5, 3);
        List<Integer> q2 = Arrays.asList(4, 8, 7);
        List<Integer> q3 = Arrays.asList(6, 9, 1);
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(q1);queries.add(q2);queries.add(q3);
        System.out.println(ResultArrayManipulation.arrayManipulation(10, queries));

        // Second Test
        List<Integer> q1 = Arrays.asList(1, 2, 100);
        List<Integer> q2 = Arrays.asList(2, 5, 100);
        List<Integer> q3 = Arrays.asList(3, 4, 100);
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(q1);queries.add(q2);queries.add(q3);
        System.out.println(ResultArrayManipulation.arrayManipulation(5, queries));

        // Third Test
        List<Integer> q1 = Arrays.asList(2, 6, 8);
        List<Integer> q2 = Arrays.asList(3, 5, 7);
        List<Integer> q3 = Arrays.asList(1, 8, 1);
        List<Integer> q4 = Arrays.asList(5, 9, 15);
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(q1);queries.add(q2);queries.add(q3);queries.add(q4);
        System.out.println(ResultArrayManipulation.arrayManipulation(10, queries));

        */
    }
}

class ResultArrayManipulation {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long max = 0;
        long[] arr = new long[n+1];

        for (List<Integer> item : queries) {
            int first = item.get(0);
            int last  = item.get(1);
            int value = item.get(2);

            arr[first - 1] += value;
            arr[last] -= value;
        }

        // Prefix Sum Array
        long sum = 0;
        for (long i : arr) {
            sum += i;
            max = Math.max(sum, max);
        }

        return max;
    }
}