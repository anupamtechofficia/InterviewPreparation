package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {

    public static int longestSubstringWithKDistinctCharacters(String input, int k){
        int startWindow = 0;
        int endWindow = 0;
        int sum = 0;
        int result = 0;
        Map<Character,Integer> charMap = new HashMap<>();
        int currentDistinctElement = 0;
        while (endWindow < input.length()) {
            char character = input.charAt(endWindow);
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
            while (charMap.size()>k) {
                char charToRemove = input.charAt(startWindow++);
                charMap.put(charToRemove, charMap.get(charToRemove)-1);
                if(charMap.get(charToRemove) ==0){
                    charMap.remove(charToRemove);
                }
            }
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 2));
        System.out.println(longestSubstringWithKDistinctCharacters("araaci", 1));
        System.out.println(longestSubstringWithKDistinctCharacters("cbbebi", 3));

    }
}
