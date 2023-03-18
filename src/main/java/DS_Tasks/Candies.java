package DS_Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candies {

    public static void main(String[] args) {

        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        boolean[] result = new boolean[5];

        for (int i = 0; i < candies.length; i++) {
            if ((candies[i] + extraCandies) >= 5) {
                result[i] = true;
            } else result[i] = false;
        }
        System.out.println(Arrays.toString(result));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max=Arrays.stream(candies).max().getAsInt();//O(n)

        // create another array
        for (int candy : candies) { // O(n)
            result.add(candy+extraCandies>=max);
        }
        return result;
    }
    public static List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>(); // return type
        int max=-1;
        //find max
        for (int i = 0; i < candies.length; i++) {
            if(candies[i]>max) max=candies[i];
        }//O(n)


        for (int i = 0; i < candies.length; i++) {
            if(candies[i]+extraCandies>=max) result.add(true);
            else result.add(false);
        } // O(n)
        // in total we have O(n) +O(n) = O(2n) which results in O(n)
        return result;
    }
}