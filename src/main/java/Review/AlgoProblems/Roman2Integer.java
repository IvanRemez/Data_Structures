package Review.AlgoProblems;
/*
Problem : Roman to Integer
Difficulty: Easy Category: String & Hash Map

• Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
• SymbolValue I 1 V 5 X 10 L 50 C 100 D 500 M 1000
For example, 2 is written as II in Roman numeral,just two one's added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
which is XX + V + II.
• Roman numerals are usually written largest to smallest from left to right. However,
the numeral for four is not IIII. Instead, the number four is written as IV. Because
the one is before the five we subtract it making four. The same principle applies to the
number nine, which is written as IX. There are six instances where subtraction is used:

• I can be placed before V(5) and X(10) to make 4 and 9.
• X can be placed before L (50) and C (100) to make 40 and 90.
• C can be placed before D (500) and M (1000) to make 400 and 900.
• Given a roman numeral, convert it to an integer.

Decision to evaluate as one or two symbols at the same time.

MC = 1000 + 100 = 1100        condition: M > C -> evaluate separately
CM = 1000 - 100 = 900         condition: C < M -> evaluate both
XI = 10 + 1 = 11              condition: X > I -> evaluate separately
IX = 10 - 1 = 9               condition: I < X -> evaluate both
 */

import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    public static void main(String[] args) {

        System.out.println(romanToInteger("CMXCIV"));   // 994
        System.out.println(romanToInteger("CXVII"));    // 117
        System.out.println(romanToInteger("DXCI"));     // 591

    }

    static int romanToInteger(String str) {
        // ("M", 1000); ("D", 500);("C", 100);("L", 50);("X", 10);("V", 5);("I", 1);
        // Map for Roman Numerals
        Map<String, Integer> values = new HashMap<>();
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);

        int sum = 0;
        int i = 0;

        while (i < str.length()) {          // current pointer
        // get Roman symbol from String
            String currentSymbol = str.substring(i, i + 1);
        // convert to its int value
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;

            if (i + 1 < str.length()) {     // next pointer
                String nextSymbol = str.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }
            if (currentValue < nextValue) {     // if curr is smaller -> subtraction
                sum += (nextValue - currentValue);
            // both expressions evaluated together -> make double jump
                i += 2;
            } else {                            // if curr is larger -> addition
                sum += currentValue;
            // both expressions evaluated separately -> make single jump
                i++;
            }
        }
        return sum;
    }
}