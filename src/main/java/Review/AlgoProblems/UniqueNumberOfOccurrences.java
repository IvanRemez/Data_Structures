package Review.AlgoProblems;
/*
Problem : Unique Number of Occurrences
Difficulty: EasyCategory: Array, HashMap & Sets

• Given an array of integers arr, return true if the number of occurrences of each
value in the array is unique or false otherwise.

Example 1:
• Input: arr = [1,2,2,1,1,3]
• Output: true Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
No two values have the same number of occurrences.
Example 2:
• Input: arr = [1,2] Output: false
Example 3:
• Input: arr = [-3,0,1,-3,1,1,1,-3,10,0] Output: true
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {

        int[] myArray = new int[] {1, 2, 2, 1, 1, 3};
        int[] myArray2 = new int[] {1, 2};

        System.out.println("Using containsKey() AND freqMap, freqSet size comparison");
        System.out.println(uniqueOccurrences(myArray));     // true
        System.out.println(uniqueOccurrences(myArray2));    // false

        System.out.println("Using getOrDefault() AND !freqSet.add(value)");
        System.out.println(uniqueOccurrences2(myArray));
        System.out.println(uniqueOccurrences2(myArray2));
    }

    public static boolean uniqueOccurrences(int[] arr) {
    // create a HashMap (Integer,Integer) (Elements, Freq.)
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int each : arr) {
            if (freqMap.containsKey(each)) {
                freqMap.put(each, freqMap.get(each) + 1);
            } else {
                freqMap.put(each, 1);
            }
        }
// Alt. for loop using getOrDefault() method:
//        for (int each : arr) {
//            freqMap.put(each, freqMap.getOrDefault(each, 0) + 1);
//        }

    // create Set for frequencies
        Set<Integer> freqSet = new HashSet<>(); // Set won't accept duplicates

        freqSet.addAll(freqMap.values());   // add all frequencies to Set

        return freqMap.size() == freqSet.size(); // if true = NO duplicate frequencies
        // if size is different (false), it means there were duplicate frequencies
    }
    public static boolean uniqueOccurrences2(int[] arr) {
    // create a HashMap (Integer,Integer) (Elements, Freq.)
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int each : arr) {
            freqMap.put(each, freqMap.getOrDefault(each, 0) + 1);
        }
//        getOrDefault = gets Value (frequency) of each element or defaults to
//        specified # (0) if absent. Then we + 1 for each time the same element key is found

        // create Set for frequencies (NO duplicates)
        Set<Integer> freqSet = new HashSet<>();

        for (Integer value : freqMap.values()) {

            if (!freqSet.add(value)) {
            // ^^ will return false if value (freq) is duplicate since Set does NOT accept this
            // opposite of false will make if statement true
                return false;
            }
        }
        return true;
    }
}