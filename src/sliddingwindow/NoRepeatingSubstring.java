package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatingSubstring {
    public static int noRepeatingSubstring(String input){
        int startWindow = 0;
        int endWindow = 0;
        int result = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        while (endWindow < input.length()) {

            if (charMap.getOrDefault(input.charAt(endWindow), -1)>=startWindow) {
                startWindow = charMap.get(input.charAt(endWindow))+1;
            }
            charMap.put(input.charAt(endWindow), endWindow);
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(noRepeatingSubstring("aabccbb"));
        System.out.println(noRepeatingSubstring("abbbb"));
        System.out.println(noRepeatingSubstring("abccde"));

    }
}
