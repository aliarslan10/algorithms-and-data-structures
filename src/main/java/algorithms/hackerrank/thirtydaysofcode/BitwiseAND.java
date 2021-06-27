package algorithms.hackerrank.thirtydaysofcode;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * N : Value count of the Set.
 * K : Limitation.
 *
 * Example: if N = 5 and K = 2 then our Set is S = {1, 2, 3, 4, 5}
 *          according to AND(&) bitwise process we should return
 *          bigger value which is less than "K" value.
 */
public class BitwiseAND {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                int count = Integer.parseInt(firstMultipleInput[0]);
//
//                int lim = Integer.parseInt(firstMultipleInput[1]);
//
//                int res = Result.bitwiseAnd(count, lim);
//
//                bufferedWriter.write(String.valueOf(res));
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
    }
}

class Result {

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */

    public static int bitwiseAnd(int N, int K) {
        // Write your code here
        int[] array = IntStream.rangeClosed(1, N).toArray();
        int value = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (array[i] != array[j]) {
                    int temp = array[i] & array[j];
                    if (temp > value && temp < K) {
                        value = temp;
                    }
                }
            }
        }
        return value;
    }

}
