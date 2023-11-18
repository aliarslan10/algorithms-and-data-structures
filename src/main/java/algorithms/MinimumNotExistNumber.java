package algorithms;

import java.util.*;

/**
 * given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */
public class MinimumNotExistNumber {

    public static void main(String[] args) {

        int[] A = {1, 3, 10, 20, 30, 4, 1, 2};

        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // Implement your solution here

        int minimum = 1;

        if (A.length == 0)
            return minimum;

        List<Integer> list = new LinkedList<>();

        for (int item : A) {
            if (item > 0) {
                list.add(item);
            }
        }

        if (list.isEmpty())
            return minimum;

        Collections.sort(list);

        for (int i = 0; i < list.toArray().length; i++) {

            if (minimum < list.get(i))
                return minimum;

            minimum = list.get(i) + 1;
        }

        return minimum;
    }
}
