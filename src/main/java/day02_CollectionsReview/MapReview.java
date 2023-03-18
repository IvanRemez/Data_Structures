package day02_CollectionsReview;

import java.util.HashMap;
import java.util.Map;

public class MapReview {

    public static void main(String[] args) {

        String str = "JJavvaDDevvelloopperr";

        System.out.println(find1stNonRepeating(str));

    }
    public static Character find1stNonRepeating(String str) {

// Create a Map - this will cost O(n) space complexity
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
// Count the frequency of chars
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
        // char = key, count = value
                count = map.get(ch); // returns count value
                map.put(ch, count + 1);
            }else {
                map.put(ch, 1);
            }
        }
// Start from beginning and check if there is a char with freq. 1
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return null;
    }
}
