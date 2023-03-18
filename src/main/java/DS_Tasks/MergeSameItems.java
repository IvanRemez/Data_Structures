package DS_Tasks;

import java.util.*;

public class MergeSameItems {
    public static void main(String[] args) {
        int[][] items1 = {{1, 1}, {4, 5}, {3, 8}};
        int[][] items2 = {{3, 1}, {1, 5}};
//        System.out.println(mergeSimilarItems(items1, items2));



    }

//    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        // loop through item1 - add/update in map
//
//        updateMap(items1, map);
//        // loop through items2 - add/update in map
//
//        updateMap(items2, map);
//
//        // sort in ascending order
//
//        return map.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getKey);
//
//    }

    public static void updateMap(int[][] items, HashMap<Integer, Integer> map) {

        for (int[] item : items) {

            int key = item[0];
            int value = item[1];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
    }
}