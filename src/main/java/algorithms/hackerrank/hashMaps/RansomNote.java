package algorithms.hackerrank.hashMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * https://github.com/aliarslan10
 *
 * Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting.
 * He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note.
 * The words in his note are case-sensitive and he must use only whole words available in the magazine.
 * He cannot use substrings or concatenation to create the words he needs.
 *
 * Example :
 * magazine = "attack at dawn" , note = "Attack at dawn" => result should be NO
 * magazine = "give me one grand today night" , note = "give one grand today" => result should be YES
 *
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */

public class RansomNote {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        ResultRansomNote.checkMagazine(magazine, note);

        bufferedReader.close();

        /*For testing on local from intellij

        // CASE - 1
        List<String> magazine = new LinkedList<String>(Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts"));
        List<String> note = new LinkedList<String>(Arrays.asList("ive", "got", "some", "coconuts"));

        // CASE - 2
        List<String> magazine = new LinkedList<String>(Arrays.asList("give", "me", "one", "grand", "today", "night"));
        List<String> note = new LinkedList<String>(Arrays.asList("give", "one", "grand", "today"));

        //ResultRansomNote.checkMagazine(magazine, note);
        */
    }
}

class ResultRansomNote {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : magazine) {
            Integer wordCount = hashMap.get(s);
            if (wordCount == null)
                hashMap.put(s, 1);
            else
                hashMap.replace(s, ++wordCount);
        }

        for (String item : note) {
            Integer wordCount = hashMap.get(item);
            if (wordCount != null) {
                hashMap.replace(item, --wordCount);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    public static void checkMagazineWithoutHashMap(List<String> magazine, List<String> note) {
        for (String item : note) {
            if (!magazine.remove(item)) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }
}