package day02_CollectionsReview;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetReview {

    public static void main(String[] args) {

// 1. Create a Set
        Set<Student> set = new LinkedHashSet<>();
// 2. Add elements
        set.add(new Student(1, "Jack"));
        set.add(new Student(2, "Julia"));
        set.add(new Student(3, "Mike"));
        set.add(new Student(4, "Mary"));
        System.out.println(set.add(new Student(4, "Mary")));
        // ^^ false - Set does NOT accept DUPLICATES

        System.out.println(set);
        System.out.println("-----------------------------------------");

        System.out.println(firstRepeatingChar("Javva Developer"));
    }

    public static Character firstRepeatingChar(String str) {
// Create a HashSet
        Set<Character> chars = new HashSet<>();

// Iterate over the Char array and add chars into HashSet
        for (Character ch : str.toCharArray()) {

// If add operation is False, return that char
            if (!chars.add(ch)) {
                return ch;
            }
            // ^ Since Set does not allow Duplicates,
            // adding a duplicate char will return a False boolean
            // when if statement is false -> return char
        }
        return null;
    }   // Time Complexity = O(n), Space Complexity = O(n)

}
