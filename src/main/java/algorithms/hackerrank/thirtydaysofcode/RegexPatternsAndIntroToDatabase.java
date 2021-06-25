package algorithms.hackerrank.thirtydaysofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Consider a database table, Emails, which has the attributes First Name and Email ID.
 * Given N rows of data simulating the Emails table, print an alphabetically-ordered list of people whose email address ends @gmail in.
 * Print an alphabetically-ordered list of first names for every user with a gmail account. Each name must be printed on a new line.
 * https://www.hackerrank.com/challenges/30-regex-patterns/problem
 */
public class RegexPatternsAndIntroToDatabase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = new LinkedList<>();

        IntStream.range(0, N).forEach(NItr -> {
            try {
                // replaceAll("\\s+$", "") removes blank and enter character from end of the string
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];
                String emailID = firstMultipleInput[1];

                if (emailID.contains("@gmail.com")) {
                    names.add(firstName);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        names.stream().sorted().forEach(System.out::println);

        bufferedReader.close();
    }
}
