package DS_Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class LetterCandles {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Read inputs here!

        System.out.println("Enter letter count: ");
        int letterCount = Integer.parseInt(reader.readLine());

        System.out.println("Enter number candles that can be removed : ");
        int m = Integer.parseInt(reader.readLine());

        System.out.println("Enter candle letters : ");
        String letters = reader.readLine();

        System.out.println(letterCandlesCost(letterCount, m, letters));
    }

    public static int letterCandlesCost(int letterCount, int m, String str) {
        int cost = 0;
// Create a HashMap
        // O(n<26)
        Map<Character, Integer> map = new HashMap<>();
// Calculate frequencies
        int count = 0;
        // O(n)
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
// Get values and sort them
        // nlogn (n is NOT greater than 26)
        List<Integer> letterFreq = map.values().stream()
                .sorted((o1, o2) -> o2.compareTo(o1)).collect(toList());
// Minimize cost
        int index = 0;
        while (m > 0 && index < letterFreq.size() - 1) {

            if (letterFreq.get(index) >= letterFreq.get(index + 1)) {
                letterFreq.set(index, letterFreq.get(index) - 1);
                m--;
            } else if (index > 0 && letterFreq.get(index) < letterFreq.get(index) - 1) {
                index--;
            }else index++;
        }
// Calculate minimized cost
        // O(n) (n is NOT greater than 26, in fact it is constant)
        for (Integer num : letterFreq) {
            cost += num * num;
        }
        // O(n)
        return cost;
    }

    public static int letterCandlesCost_Ivan(int letterCount, int m, String str) {
        int cost = 0;

        int[] freq = new int[str.length()];
        int i, j;

        //Converts given string into character array
        char string[] = str.toCharArray();

        for (i = 0; i < str.length(); i++) {
            freq[i] = 1;
            for (j = i + 1; j < str.length(); j++) {
                if (string[i] == string[j]) {
                    freq[i]++;

                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
        }

        //Displays each character and their corresponding frequency
        System.out.println("Characters and their corresponding frequencies");
        for (i = 0; i < freq.length; i++) {
            if (string[i] != ' ' && string[i] != '0')
                System.out.println(string[i] + "-" + freq[i]);
        }
        return cost;
    }
}