package algorithms.hackerrank.thirtydaysofcode;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Your company needs a function that meets the following requirements:
 * 1 - For a given array of  integers, the function returns the index of the element with the minimum value in the array.
 * If there is more than one element with the minimum value, it returns the smallest one.
 * 2 - If an empty array is passed to the function, it raises an exception.
 * A colleague has written this method. The implementation in Python is listed below.
 * Implementations in other languages can be found in the code template.
 * https://www.hackerrank.com/challenges/30-testing/problem
 */
public class Testing {

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }


    private static class TestDataEmptyArray {

        private static int[] get_array() {
            return new int[]{};
        }
    }

    private static class TestDataUniqueValues {

        private static int[] get_array() {
            return new int[]{2,1,5};
        }

        private static int get_expected_result() {
            return 1;
        }
    }

    private static class TestDataExactlyTwoDifferentMinimums {

        private static int[] get_array() {
            return new int[]{4,4,1,1,2,3};
        }

        private static int get_expected_result() {
            return 2;
        }
    }


    public static void TestWithEmptyArray() {
        try {
            int[] seq = TestDataEmptyArray.get_array();
            int result = minimum_index(seq);
        } catch (IllegalArgumentException e) {
            return;
        }
        throw new AssertionError("Exception wasn't thrown as expected");
    }

    public static void TestWithUniqueValues() {
        int[] seq = TestDataUniqueValues.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        Integer[] tmp = new Integer[seq.length];
        for (int i = 0; i < seq.length; ++i) {
            tmp[i] = Integer.valueOf(seq[i]);
        }
        if (!((new LinkedHashSet<Integer>(Arrays.asList(tmp))).size() == seq.length)) {
            throw new AssertionError("not all values are unique");
        }

        int expected_result = TestDataUniqueValues.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void TestWithExactlyTwoDifferentMinimums() {
        int[] seq = TestDataExactlyTwoDifferentMinimums.get_array();
        if (seq.length < 2) {
            throw new AssertionError("less than 2 elements in the array");
        }

        int[] tmp = seq.clone();
        Arrays.sort(tmp);
        if (!(tmp[0] == tmp[1] && (tmp.length == 2 || tmp[1] < tmp[2]))) {
            throw new AssertionError("there are not exactly two minimums in the array");
        }

        int expected_result = TestDataExactlyTwoDifferentMinimums.get_expected_result();
        int result = minimum_index(seq);
        if (result != expected_result) {
            throw new AssertionError("result is different than the expected result");
        }
    }

    public static void main(String[] args) {
        TestWithEmptyArray();
        TestWithUniqueValues();
        TestWithExactlyTwoDifferentMinimums();
        System.out.println("OK");
    }
}
