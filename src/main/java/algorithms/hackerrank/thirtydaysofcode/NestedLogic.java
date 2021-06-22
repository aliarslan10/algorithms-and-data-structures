package algorithms.hackerrank.thirtydaysofcode;
import java.util.*;

/**
 * If the book is returned on or before the expected return date, no fine will be charged: fine = 0
 * If returned after expected day but in same calendar day and year: fine = (late days) x 15
 * If returned after expected months but in same calendar year: fine = (late months) x 500
 * If the book is returned after the calendar year in which it was expected: fine = 10000
 *
 * STDIN       Function
 * -----       --------
 * 9 6 2015    day = 9, month = 6, year = 2015 (date returned)
 * 6 6 2015    day = 6, month = 6, year = 2015 (date due)
 *
 * https://www.hackerrank.com/challenges/30-nested-logic/problem
 */

public class NestedLogic {

    public static String REGEX_BLANK = "\\s+";

    public static void main(String[] args) {

        int fineAfterExpectedYears = 10000;
        int fineAfterExpectedMonths= 500;
        int fineAfterExpectedDays  = 15;

        Scanner scan = new Scanner(System.in);
        System.out.print("Returned Date : ");
        String returnedDateInput = scan.nextLine();
        System.out.print("Due Date : ");
        String dueDateInput = scan.nextLine();

        String[] returnedDate = returnedDateInput.split(REGEX_BLANK);
        int returnedDay = Integer.parseInt(returnedDate[0]);
        int returnedMonth = Integer.parseInt(returnedDate[1]);
        int returnedYear = Integer.parseInt(returnedDate[2]);

        String[] dueDate = dueDateInput.split(REGEX_BLANK);
        int dueDay = Integer.parseInt(dueDate[0]);
        int dueMonth = Integer.parseInt(dueDate[1]);
        int dueYear = Integer.parseInt(dueDate[2]);

        int fine = 0;

        if (returnedYear > dueYear) {
            fine = fineAfterExpectedYears;

        } else if (returnedYear == dueYear && returnedMonth > dueMonth) {
            fine = (returnedMonth - dueMonth) * fineAfterExpectedMonths;

        } else if (returnedMonth == dueMonth && returnedDay > dueDay) {
            fine = (returnedDay - dueDay) * fineAfterExpectedDays;
        }

        System.out.println(fine);
    }
}
