package twilio;

import java.util.Arrays;
import java.util.List;

/**
 * There is two message sms provider. We should sent this message through this operators with lower cost.
 * Operator1 can support only letters, numbers, dots, commas, blank with maximum 160 characters long
 * Operator2 can support any characters with maximum 70 characters long
 * Price of Operator1 charges 0.01$ for per message with 160 character.
 * Price of Operator2 charges 0.015$ for per message with 70 character.
 *
 * Following coding approaches open to contribution if you have better solution **** https://github.com/aliarslan10
 */

public class SmsServiceProvider {

    public static final String regexForOp1 = "^[.a-zA-Z0-9, ]*$";

    public static void main(String[] args) {
        System.out.println(solve2(Arrays.asList(
                "Circumambulate the city of dreamy Sabbatah afternoon.",
                "Call me Ishmael. Some years ago, never mind how long precisely, having little or no money in my purse, and nothing particular interest me on shore," +
                        "I thought I would sall about a little and see the watery part of the world.",
                "Once more. Say you are in the country, in some high land of lakes.",
                "Tõde ja õigus"
                )));
    }

    // O(n^2) solution
    public static double solve(List<String> messages) {

        int op1charSize = 160;
        int op2charSize = 70;
        double op1charPrice = 0.01;
        double op2charPrice = 0.015;
        double totalPrice = 0;

        for (String msg : messages) {
            if (msg.matches(regexForOp1)) {
                String sub = "";
                while (msg.length() > op1charSize) {
                    sub = msg.substring(0, op1charSize);
                    msg = msg.replace(sub,"");
                    totalPrice += op1charPrice;
                }
                totalPrice += op1charPrice;
            } else {
                while (msg.length() > op2charSize) {
                    String sub = "";
                    sub = msg.substring(0, op1charSize);
                    msg = msg.replace(sub,"");
                }
                totalPrice += op2charPrice;
            }
        }

        return totalPrice;
    }

    // O(n) solution
    public static double solve2(List<String> messages) {

        int op1charSize = 160;
        int op2charSize = 70;
        double op1charPrice = 0.01;
        double op2charPrice = 0.015;
        double totalPrice = 0;
        String server1 = "";
        String server2 = "";
        int msgSizeServer1 = 0;
        int msgSizeServer2 = 0;

        for (String msg : messages) {
            if (msg.matches(regexForOp1)) {
                server1 = server1.concat(msg);
                msgSizeServer1++;
            } else {
                server2 = server2.concat(msg);
                msgSizeServer2++;
            }
        }

        // get max because, already separately sent message should calculate separated independently from size
        msgSizeServer1 = Math.max(msgSizeServer1, (server1.length() / op1charSize));
        msgSizeServer2 = Math.max(msgSizeServer2, (server2.length() / op2charSize));

        // if size is one add price as is otherwise calculate the price
        totalPrice = msgSizeServer1 > 1 ? msgSizeServer1 * op1charPrice + op1charPrice : op1charPrice;
        totalPrice += msgSizeServer2 > 1 ? msgSizeServer2 * op2charPrice + op2charPrice: op2charPrice;

        return totalPrice;
    }
}

