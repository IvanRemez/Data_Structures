package Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapReview {

    public static void main(String[] args) {

        Map<Integer, String> studentsMap = new HashMap<>();
        studentsMap.put(1, "Jack");
        studentsMap.put(2, "Julia");
        studentsMap.put(3, "Alison");

// How to get values from a map
        List<String> list = studentsMap.values().stream().collect(Collectors.toList());

// How to get values and sort them
        List<String> list2 = studentsMap.values().stream().sorted((o1, o2) -> o1.compareToIgnoreCase(o2)).collect(Collectors.toList());
        System.out.println(list2);

        System.out.println("Printing Entry Set:");
        Set<Map.Entry<Integer, String>> entries = studentsMap.entrySet();
        System.out.println(entries);

        System.out.println("Printing Key Set:");
//        Set<Integer> keySet = studentsMap.keySet();
//        System.out.println(keySet);
        for (Integer integer : studentsMap.keySet()) {      // Better performance!
            System.out.println(integer);
        }
    }
}
