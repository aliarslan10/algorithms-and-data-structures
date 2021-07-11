package algorithms.hackerrank.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */

public class TwoDimensionArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = ResultTwoDimensionArray.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        /*For testing on local from intellij
        List<List<Integer>> arrList = new ArrayList<>();
        arrList.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arrList.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        arrList.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        arrList.add(Arrays.asList(0, 0, 2, 4, 4, 0));
        arrList.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        arrList.add(Arrays.asList(0, 0, 1, 2, 4, 0));
        long result = ResultTwoDimensionArray.hourglassSum(arrList);
        System.out.println(result);
        */
    }
}


class ResultTwoDimensionArray {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int count, max = 0;

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.get(i).size() - 2; j++) {

                count = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) + arr.get(i+1).get(j+1)
                        + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                max = (count > max || (i == 0 && j == 0)) ? count : max;
            }
        }

        return max;
    }

}
