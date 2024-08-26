package sliddingwindow;

import java.util.HashMap;
import java.util.Map;

public class SameLettersAfterReplacement {
    public static int sameLettersAfterReplacement(String input, int k){
        int startWindow = 0;
        int endWindow = 0;
        int result = 0;
        int currentMaxCharacterCount = 1;
        Map<Character,Integer> charMap = new HashMap<>();
        while (endWindow < input.length()) {
            char character = input.charAt(endWindow);
            charMap.put(character, charMap.getOrDefault(character, 0) + 1);
            currentMaxCharacterCount = Math.max(currentMaxCharacterCount, charMap.getOrDefault(character,0));
            while (((endWindow-startWindow+1)-currentMaxCharacterCount)>k) {
                char charToRemove = input.charAt(startWindow++);
                charMap.put(charToRemove, charMap.get(charToRemove)-1);
            }
            result = Math.max(result, endWindow - startWindow + 1);
            endWindow++;
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(sameLettersAfterReplacement("aabccbb", 2));
        System.out.println(sameLettersAfterReplacement("abbcb", 1));
        System.out.println(sameLettersAfterReplacement("abccde", 1));

    }
}
