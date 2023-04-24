package Review.AlgoProblems;
/*
Problem: Largest Range
Difficulty: Hard Category: Arrays

• Write a function that takes in an array of integers and returns an array of length 2
representing the largest range of integers contained in that array. The first number in
the output array should be the first number in the range, while the second number should
be the last number in the range. A range of numbers is defined as a set of numbers that
come right after each other in the set of real integers.
For instance, the output array [2, 6] represents the range {2, 3, 4, 5, 6},
which is a range of length 5. Note that numbers don't need to be sorted or adjacent in
the input array in order to form a range. You can assume that there will only be one
largest range.

• Sample Input:     array=[1,11,3,0,15,5,2,4,10,7,12,6]
• Sample Output:    [0,7]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static void main(String[] args) {

        int[] myArray = new int[] {6, 5, 4, 3, 2, 1, 0};    // [0, 6]
        int[] myArray2 = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6}; // [0, 7]


        System.out.println(Arrays.toString(largestRange(myArray)));
        System.out.println(Arrays.toString(largestRange(myArray2)));
    }

    public static int[] largestRange(int[] array) {

        int[] bestRange = new int[2];
            // 1st field is start value
            // 2nd field is end value

        int longestRange = 0;
        Map<Integer, Boolean> visited = new HashMap<>();
        // map to check if integer has been visited

        for (int each : array) {
            visited.put(each, false);   // false = NOT visited
        }
        for (int each : array) {
            if (visited.get(each)) {
                continue;   // if visited, skip the rest and run next iteration of for loop
            }
            int currentLength = 1;
            // ^^ default range length for integer with no consecutive integers
            // to either side of it

            int left = each - 1;    // consecutive integer to the left of each
            int right = each + 1;   // consecutive integer to the right of each
        // find the left edge of the current (each) value
            while (visited.containsKey(left)) {
                visited.put(left, true);
                currentLength++;
                left--;
            }
        // find the right edge
            while (visited.containsKey(right)) {
                visited.put(right, true);
                currentLength++;
                right++;
            }
            if (currentLength > longestRange) {
                longestRange = currentLength;
                bestRange = new int[] {left + 1, right - 1};
            // since we -1 from each for left and +1 for right in the beginning
            // need to +1 left and -1 right to find each value for the actual range
            }
        }
        return bestRange;
    }
}