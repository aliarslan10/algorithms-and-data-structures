package algorithms.hackerrank.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * A left rotation operation on an array shifts each of the array's elements 1 unit to the left. For example, if 2 left
 * left rotations are performed on array [1, 2, 3, 4, 5] hen the array would become [3, 4, 5, 1, 2]
 * Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
 * Huge example input : https://hr-testcases-us-east-1.s3.amazonaws.com/24100/input08.txt?AWSAccessKeyId=AKIAR6O7GJNX5DNFO3PV&Expires=1626161525&Signature=ahDI4jpWNDXJkpTIQ5tLIHCkJns%3D&response-content-type=text%2Fplain
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 */

public class LeftRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = ResultLeftRotation.rotLeft(a, d);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();

        /*For testing on local from intellij
        List<Integer> result = ResultLeftRotation.rotLeft(Arrays.asList(1, 2, 3, 4, 5), 4);
        result.forEach(System.out::print);*/
    }
}


class ResultLeftRotation {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        Integer[] arr = new Integer[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = a.get((i+d) % a.size());
        }
        return Arrays.asList(arr);
    }
}
