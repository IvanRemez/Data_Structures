package DS_Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[]{4, 7, 2, 11};

        System.out.println(Arrays.toString(twoSumSolution_Brute(arr, 9)));

        System.out.println(Arrays.toString(twoSumSolution_Optimal(arr, 9)));
    }

// Brute force - O(n^2)
    public static int[] twoSumSolution_Brute(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (i != j) {
                    if (arr[i] + arr[j] == target) {
                        return new int[]{i, j};
                    }
                }   // O(n^2)
            }
        }
        return new int[]{};
    }

// Optimal (HashMap) - O(n) (space complexity = O(n) )
    public static int[] twoSumSolution_Optimal(int[] arr, int target) {
// Create HashMap
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int potentialMatch = target - arr[i];

            if (map.containsKey(potentialMatch)) {
                return new int[] {map.get(potentialMatch), i};
            }else {
                map.put(arr[i], i);
            }
        }
        return new int[]{};
    }
}
/*
Problem: Two Sum
• Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
• You may assume that each input would have exactly one solution, and you may not use the same element twice.
• You can return the answer in any order.
• No solution will return empty array.
Example:
Input: nums = [2, 7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */