package DS_Tasks;

import java.util.ArrayList;

public class BusStops {

    public static void main(String[] args) {

        ArrayList<int[]> busStops = new ArrayList<int[]>();
        busStops.add(new int[] {10,0}); // 1st stop
        busStops.add(new int[] {3,5});
        busStops.add(new int[] {2,5});  // last stop

        System.out.println(countPassengers(busStops));
    }

    public static int countPassengers(ArrayList<int[]> stops) {

        int numOfPeople = 0;
// Runs in O(n) complexity b/c there is a single loop with size n
        for (int i = 0; i < stops.size(); i++) {

            numOfPeople = numOfPeople + stops.get(i)[0] - stops.get(i)[1];
        }
        return numOfPeople;
    }
}
