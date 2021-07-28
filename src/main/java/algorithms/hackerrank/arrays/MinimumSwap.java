package algorithms.hackerrank.arrays;

import java.io.*;
import java.util.*;

/**
 * You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending order.
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */

public class MinimumSwap {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();

        /* For testing on local from intellij
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
        */

    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swap = 0, index = 0;
        while (index != arr.length) {

            if (arr[index] != index+1) {

                int temp = arr[arr[index] - 1];
                arr[arr[index] - 1] = arr[index];
                arr[index] = temp;

                swap++;
                index = -1;
            }
            index++;
        }
        return swap;
    }

}
