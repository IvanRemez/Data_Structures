package Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListReview {

    public static void main(String[] args) {

// Convert an Array to ArrayList with Arrays.asList()
        Integer[] arr = {7, 8, 1, 2, 3, 4, 6};
        List<Integer> list = Arrays.asList(arr);
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(arr));

// ... with Collections.addAll()

        ArrayList<Integer> list3 = new ArrayList<>();
        Collections.addAll(list3, arr);
        System.out.println(list3);

// Convert an ArrayList to Array
        Integer[] arr2 = list3.toArray(new Integer[0]);

// Convert an ArrayList to Array using Streams
        int[] arr3 = list3.stream().mapToInt(i -> i).toArray();

// Sort without Comparator
        Collections.sort(list2);
        System.out.println(list2);
// ** Sorting Time Complexity = nlogn **

// Reverse


    }
}
