package algorithms;

/**
 * Finding number from huge collection
 * with different approach and comparing their performance
 */
public class FindNumberAlgorithm {

    public static void main(String[] args) {
        findNumberFromHugeCollection();
        findNumberFromHugeCollectionByEvenAndOddNumbers();
        findNumberFromHugeCollectionByDividingTheCollection();
    }

    private static void findNumberFromHugeCollection() {
        System.out.println("ALGORITHM - 1 \n---------");
        long startTime = System.currentTimeMillis();
        int x = 9999996;
        int n = 10000000;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count++;
            if (i == x) {
                System.out.println("Value " + x  + " founded by " + count + " times try");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time : " + (endTime - startTime) + " ms \n");
    }

    private static void findNumberFromHugeCollectionByEvenAndOddNumbers() {
        System.out.println("ALGORITHM - 2 \n---------");
        long startTime = System.currentTimeMillis();
        int x = 9999996;
        int n= 10000000;
        int count=0;
        boolean isEven = n%2 == 0;
        if(x>=0){
            if(isEven){
                for (int i = 0; i < n; i=i+2) {
                    count++;
                    if (i == x) {
                        System.out.println("Value " + x  + " founded by " +count+" try");
                        break;
                    }
                }
            }else{
                for (int i = 1; i < n; i=i+2) {
                    count++;
                    if (i == x) {
                        System.out.println("Value " + x  + " founded by " +count+" try");
                        break;
                    }
                }
            }
        }else{
            System.out.println("oops we are expecting vailid value");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total time :: "+(endTime-startTime) + " ms \n");
    }

    private static void findNumberFromHugeCollectionByDividingTheCollection() {
        System.out.println("ALGORITHM - 2 \n---------");
        Algorithm obj = new Algorithm();
        int[] numColl = new int[10000000];
        for (int i = 1; i < numColl.length; i++) {
            numColl[i] = i;
        }
        int x = 9999996;
        int high = numColl.length - 1;
        long startTime = System.currentTimeMillis();
        obj.findNumber(numColl, 0, high, x);
        System.out.println("Value " + x  + " founded by " + Algorithm.count + " try");
        long endTime = System.currentTimeMillis();
        System.out.println("Total time :: " + (endTime - startTime) + " ms \n");
    }
}

/**
 * called this recursive function
 * from findNumberFromHugeCollectionByDividingTheCollection() approach to find number
 */
class Algorithm {
    static int count = 0;
    static int findNumber(int[] collection, int start, int end, int x) {
        count++;
        if (end >= start) {
            int mid = start + (end - start) / 2;
            if (collection[mid] == x)
                return mid;
            if (collection[mid] > x)
                return findNumber(collection, start, mid - 1, x);
            return findNumber(collection, mid + 1, end, x);
        }
        return -1;
    }
}
