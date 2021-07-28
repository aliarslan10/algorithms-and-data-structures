package algorithms.hackerrank.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * It is New Year's Day and people are in line for the Wonderland rollercoaster ride.
 * Each person wears a sticker indicating their initial position in the queue from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
 * One person can bribe at most two others. Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print 'Too chaotic'.
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

public class NewYearChaos {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                ResultNewYearChaos.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        /* For testing on local from intellij */
        //ResultNewYearChaos.minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
        //ResultNewYearChaos.minimumBribes(Arrays.asList(2, 5, 1, 3, 4));
        //ResultNewYearChaos.minimumBribes(Arrays.asList(5, 1, 2, 3, 7, 8, 6, 4));
        //ResultNewYearChaos.minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));
        //ResultNewYearChaos.minimumBribes(Arrays.asList(1, 2, 5, 3, 4, 7, 8, 6));
    }
}

class ResultNewYearChaos {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here

        int bribeCount = 0;
        boolean chaotic = false;

        for (int i = 0; i < q.size(); i++) {

            int distance = q.get(i) - (i+1);

            if (distance > 2) {
                chaotic = true;
                break;
            }

            int k = Math.max(0, q.get(i) - 2);
            for (int j = k; j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribeCount++;
                }
            }
        }

        if(chaotic)
            System.out.println("Too chaotic");
        else
            System.out.println(bribeCount);
    }
}
