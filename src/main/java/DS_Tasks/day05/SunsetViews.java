package DS_Tasks.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class SunsetViews {

    public static void main(String[] args) {

        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        System.out.println(sunsetViews_Stack(buildings, "EAST")); // [1, 3, 6, 7]
        System.out.println(sunsetViews_Stack(buildings, "WEST")); // [0, 1]
    }

    public static ArrayList<Integer> sunsetViews_Stack(int[] buildings, String direction) {

        Stack<Integer> stack = new Stack<>();
        // stack to hold indices of buildings which can see sunset
    // East part
        int i = 0;
        int step = 1;
    // West part
        if (direction.equalsIgnoreCase("west")) {
            i = buildings.length - 1;
            step = -1;
        }

        while (i >= 0 && i < buildings.length){

            while (!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);  // pushing building INDICES into stack
            i += step;
        }   // need to convert to ArrayList

        if (direction.equalsIgnoreCase("west")) {
            Collections.reverse(stack);
        }

        return new ArrayList<>(stack);
    }
}
